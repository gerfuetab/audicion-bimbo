package org.gerfuetab.audicionbimbo.ventas.services;

import java.util.List;
import java.util.Optional;

import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.Tarjeta;
import org.gerfuetab.audicionbimbo.carrier.models.TarjetaTokenResponse;
import org.gerfuetab.audicionbimbo.ventas.clients.CarrierClienteRest;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Plan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Proveedor;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlanPK;
import org.gerfuetab.audicionbimbo.ventas.repositories.BitacoraRepository;
import org.gerfuetab.audicionbimbo.ventas.repositories.PlanRepository;
import org.gerfuetab.audicionbimbo.ventas.repositories.ProveedorPlanRepository;
import org.gerfuetab.audicionbimbo.ventas.repositories.ProveedorRepository;
import org.gerfuetab.audicionbimbo.ventas.repositories.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentasServiceImpl implements VentasService {

	@Autowired
	private VentasRepository repository;

	@Autowired
	private ProveedorPlanRepository provPlnRepository;

	@Autowired
	private ProveedorRepository provRepository;

	@Autowired
	private PlanRepository plnRepository;

	@Autowired
	private BitacoraRepository bitacoraRepository;

	@Autowired
	private CarrierClienteRest client;

	@Override
	@Transactional(readOnly = true)
	public TarjetaTokenResponse obtenerTokenTarjeta(Tarjeta tarjeta) {
		return client.obtenerTokenTarjeta(tarjeta);
	}

	@Override
	@Transactional
	public BitacoraRecargas guardar(BitacoraRecargas transaccion) {
		return repository.save(transaccion);
	}

	@Override
	@Transactional(readOnly = true)
	public CreaRecargaResponse creaRecargaTelcel(CreaRecargaRequest creaRecargaRequest, String urlProveedor) {
		return client.creaRecargaTelcel(creaRecargaRequest, urlProveedor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> obtenProveedor(Long proveedorPK) {
		return provRepository.findById(proveedorPK);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Plan> obtenPlan(Long planPK) {
		return plnRepository.findById(planPK);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProveedorPlan> obtenProveedorPlan(ProveedorPlanPK proveedorPlanPK) {
		return provPlnRepository.findById(proveedorPlanPK);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BitacoraRecargas> obtenBitacora() {
		return (List<BitacoraRecargas>) bitacoraRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<BitacoraRecargas> ValidaMismaTransaccion(String numero, Long proveedor_id, Long plan_id) {
		return (List<BitacoraRecargas>) bitacoraRepository.validaMismaTransaccion(numero, proveedor_id, plan_id);
	}

}
