package org.gerfuetab.audicionbimbo.ventas.models;

import org.gerfuetab.audicionbimbo.ventas.models.entity.Proveedor;

public class ReporteProveedorCount {

	private Proveedor proveedor;
	private Long totalRegistros;
	private Double totalMonto;
	
	
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
	public ReporteProveedorCount(Proveedor proveedor, Long totalRegistros, Double totalMonto) {
		super();
		this.proveedor = proveedor;
		this.totalRegistros = totalRegistros;
		this.totalMonto = totalMonto;
	}
	public ReporteProveedorCount() {
		super();
	}
	
	
	
	
	
	
}
