package org.gerfuetab.audicionbimbo.ventas.services;

import org.gerfuetab.audicionbimbo.ventas.models.PeriodoTiempo;
import org.gerfuetab.audicionbimbo.ventas.models.Reporte;
import org.gerfuetab.audicionbimbo.ventas.models.ReportePlan;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedor;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlan;

public interface ReportesService {

	Reporte reporteVentasDiario();

	ReportePlan reportePlanDiario();

	ReporteProveedor reporteProveedorDiario();

	ReporteProveedorPlan reporteProveedorPlanDiario();

	Reporte reporteVentas(PeriodoTiempo periodoTiempo);

	ReportePlan reportePlan(PeriodoTiempo periodoTiempo);

	ReporteProveedor reporteProveedor(PeriodoTiempo periodoTiempo);
	
	ReporteProveedorPlan reporteProveedorPlan(PeriodoTiempo periodoTiempo);
	
	Reporte reporteVentasNumero(PeriodoTiempo periodoTiempo);
	
	ReporteProveedor reporteProveedorPlanID(PeriodoTiempo periodoTiempo);

}
