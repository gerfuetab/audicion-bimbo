package org.gerfuetab.audicionbimbo.ventas.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.RealizaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.TarjetaTokenResponse;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargaPK;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Plan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Proveedor;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlanPK;
import org.gerfuetab.audicionbimbo.ventas.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentasController {

	@Autowired
	private VentasService service;


	private final Logger LOGGER = LogManager.getLogger(this.getClass());

	@PostMapping("/ventas/realizaRecarga")
	public ResponseEntity<CreaRecargaResponse> realizaRecarga(
			@Valid @RequestBody RealizaRecargaRequest realizaRecargaRequest) {
		int logUniqueId = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
		ThreadContext.put("uniqueID", String.valueOf(logUniqueId));
		LOGGER.info("Transacción de compra a proveedor / numero:" + realizaRecargaRequest.getTelefono().getNumero()
				+ " proveedorID: " + realizaRecargaRequest.getProveedor_id() + " planID: "
				+ realizaRecargaRequest.getPlan_id());
		Proveedor prov = new Proveedor();
		Plan plan = new Plan();
		ProveedorPlan provPlan = new ProveedorPlan();
		try {
			prov = service.obtenProveedor(realizaRecargaRequest.getProveedor_id()).get();
			plan = service.obtenPlan(realizaRecargaRequest.getPlan_id()).get();
			ProveedorPlanPK prvPlaPK = new ProveedorPlanPK(prov, plan);
			provPlan = service.obtenProveedorPlan(prvPlaPK).get();
			if (provPlan == null) {
				LOGGER.error("Proveedor y/o plan no validos / " + 230);
				return ResponseEntity.ok(new CreaRecargaResponse("Proveedor y/o plan no validos", 230));

			}
		} catch (Exception ex) {
			LOGGER.error("Proveedor y/o plan no validos", 230);
			return ResponseEntity.ok(new CreaRecargaResponse("Proveedor y/o plan no validos", 230));

		}

		// Valida que no exista la misma transaccion en menos de 15 min
		List<BitacoraRecargas> mismaTransaccion = service.ValidaMismaTransaccion(
				realizaRecargaRequest.getTelefono().getNumero(), prov.getProveedor_id(), plan.getPlan_id());
		if (!mismaTransaccion.isEmpty()) {
			LOGGER.error(
					"Debes de esperar minimo 15 min antes de comprar el mismo plan para este mismo numero / " + 240);
			return ResponseEntity.ok(new CreaRecargaResponse(
					"Debes de esperar minimo 15 min antes de comprar el mismo plan para este mismo numero", 240));

		}
		// Obtener Token de tarjeta
		TarjetaTokenResponse tokenResponse = service.obtenerTokenTarjeta(realizaRecargaRequest.getTarjeta());
		if (tokenResponse.getCodigo() != 210) {
			LOGGER.error(tokenResponse.getMensaje() + " / " + 220);
			return ResponseEntity.ok(new CreaRecargaResponse(tokenResponse.getMensaje(), 220));
		}
		// HacerRecarga
		CreaRecargaRequest recargaRequest = new CreaRecargaRequest(plan.getPrecio(),
				realizaRecargaRequest.getTelefono(), realizaRecargaRequest.getMetodoPago(), tokenResponse.getToken(),
				realizaRecargaRequest.getTipo(), realizaRecargaRequest.getTipoPaquete(),
				realizaRecargaRequest.getIdExterno());
		CreaRecargaResponse recargaResponse = service.creaRecargaTelcel(recargaRequest, prov.getUrl());
		if (recargaResponse.getCodigo() == 210) {
			// Guardar Bitacora
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm:ss");
			LocalDateTime fecha_transaccion = LocalDateTime.parse(recargaResponse.getRecarga().getCreacion(),
					formatter);
			BitacoraRecargaPK bitRecPK = new BitacoraRecargaPK(UUID.randomUUID(), provPlan);
			BitacoraRecargas biRec = new BitacoraRecargas(bitRecPK, recargaResponse.getRecarga().getId(),
					recargaResponse.getRecarga().getNumeroAutorizacionPago(),
					recargaResponse.getRecarga().getNumeroAutorizacionPaquete(),
					recargaResponse.getRecarga().getMonto(),
					recargaResponse.getRecarga().getTelefono().getCodigo_pais(),
					recargaResponse.getRecarga().getTelefono().getCodigo_area(),
					recargaResponse.getRecarga().getTelefono().getPrefijo(),
					recargaResponse.getRecarga().getTelefono().getNumero(), fecha_transaccion);
			service.guardar(biRec);
		}
		LOGGER.info("Resolución de transacción de compra a proveedor para numero "
				+ recargaResponse.getRecarga().getTelefono().getNumero() + ": " + "id_transaccion_carrier= "
				+ recargaResponse.getRecarga().getId() + "estado_transaccion_carrier= "
				+ recargaResponse.getRecarga().getEstado());
		return ResponseEntity.ok(new CreaRecargaResponse(recargaResponse.getMensaje(), recargaResponse.getRecarga(),
				recargaResponse.getCodigo()));
	}

}
