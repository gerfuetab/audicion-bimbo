package org.gerfuetab.audicionbimbo.ventas.models;

import org.gerfuetab.audicionbimbo.ventas.models.entity.Plan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.Proveedor;

public class ReporteProveedorPlanCount {

	private Proveedor proveedor;
	private Plan plan;
	private Long totalRegistros;
	private Double totalMonto;
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Long getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	public Double getTotalMonto() {
		return totalMonto;
	}
	public void setTotalMonto(Double totalMonto) {
		this.totalMonto = totalMonto;
	}
	public ReporteProveedorPlanCount(Proveedor proveedor, Plan plan, Long totalRegistros, Double totalMonto) {
		super();
		this.proveedor = proveedor;
		this.plan = plan;
		this.totalRegistros = totalRegistros;
		this.totalMonto = totalMonto;
	}
	public ReporteProveedorPlanCount() {
		super();
	}
	
	
	
}
