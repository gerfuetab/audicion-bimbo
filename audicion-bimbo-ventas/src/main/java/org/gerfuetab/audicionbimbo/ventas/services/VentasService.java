package org.gerfuetab.audicionbimbo.ventas.services;

import java.util.List;
import java.util.Optional;

import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.Tarjeta;
import org.gerfuetab.audicionbimbo.carrier.models.TarjetaTokenResponse;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Plan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Proveedor;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlanPK;

public interface VentasService {

	TarjetaTokenResponse obtenerTokenTarjeta(Tarjeta tarjeta);

	BitacoraRecargas guardar(BitacoraRecargas transaccion);

	CreaRecargaResponse creaRecargaTelcel(CreaRecargaRequest creaRecargaRequest, String urlProveedor);

	Optional<Proveedor> obtenProveedor(Long proveedorPK);

	Optional<Plan> obtenPlan(Long planPK);

	Optional<ProveedorPlan> obtenProveedorPlan(ProveedorPlanPK proveedorPlanPK);

	List<BitacoraRecargas> obtenBitacora();

	List<BitacoraRecargas> ValidaMismaTransaccion(String numero, Long proveedor_id, Long plan_id);
}
