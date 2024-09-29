package org.gerfuetab.audicionbimbo.proveedorplan.controllers;


import org.gerfuetab.audicionbimbo.proveedorplan.models.PlanResponse;
import org.gerfuetab.audicionbimbo.proveedorplan.models.PlanXProveedorResponse;
import org.gerfuetab.audicionbimbo.proveedorplan.models.ProveedorResponse;
import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Plan;
import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Proveedor;
import org.gerfuetab.audicionbimbo.proveedorplan.services.ProveedorPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class ProveedorPlanController {
	
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

	@Autowired
	private ProveedorPlanService service;

	@CrossOrigin
	@GetMapping("/proveedores")
	public ResponseEntity<ProveedorResponse> listar() {

		List<Proveedor> proveedores = service.listar();
		if (proveedores.isEmpty()) {
			return ResponseEntity
					.ok(new ProveedorResponse(220, "Proveedores no encontrados", new ArrayList<>()));
		}
		return ResponseEntity.ok(new ProveedorResponse(210, "Planes encontrados", proveedores));

	}
	
	@CrossOrigin
	@GetMapping("/planes")
	public ResponseEntity<PlanResponse> listarPlan() {
		List<Plan> planes = service.listarPlan();
		if (planes.isEmpty()) {
			return ResponseEntity.ok(new PlanResponse(220, "Planes no encontrados", new ArrayList<>()));
		}
		return ResponseEntity.ok(new PlanResponse(210, "Planes encontrados", planes));
	}

	@CrossOrigin
	@GetMapping("/planXProveedor/{proveedor_id}")
	public ResponseEntity<PlanXProveedorResponse> detalle(@PathVariable Long proveedor_id) {
		LOGGER.info("Se inicia obtención de planes por proveedor");
		List<Plan> planes = service.planXProveedor(proveedor_id);
		if (planes.isEmpty()) {
			LOGGER.info("Planes no encontrados para proveedor");
			LOGGER.info("Se finaliza obtención de planes por proveedor");
			return ResponseEntity
					.ok(new PlanXProveedorResponse(220, "Planes no encontrados para proveedor", new ArrayList<>()));
		}
		LOGGER.info("Planes encontrados para proveedor");
		LOGGER.info("Se finaliza obtención de planes por proveedor");
		return ResponseEntity.ok(new PlanXProveedorResponse(210, "Planes encontrados para proveedor", planes));
	}
}
