package org.gerfuetab.audicionbimbo.ventas.models;

import java.util.List;

public class ReporteProveedorPlan {

	private String mensaje;
	private int codigo;
	private Double totalMonto;
	private List<ReporteProveedorPlanCount> datos;
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Double getTotalMonto() {
		return totalMonto;
	}
	public void setTotalMonto(Double totalMonto) {
		this.totalMonto = totalMonto;
	}
	public List<ReporteProveedorPlanCount> getDatos() {
		return datos;
	}
	public void setDatos(List<ReporteProveedorPlanCount> datos) {
		this.datos = datos;
	}
	public ReporteProveedorPlan(String mensaje, int codigo, Double totalMonto, List<ReporteProveedorPlanCount> datos) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.totalMonto = totalMonto;
		this.datos = datos;
	}
	public ReporteProveedorPlan() {
		super();
	}
	public ReporteProveedorPlan(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	
	



}
