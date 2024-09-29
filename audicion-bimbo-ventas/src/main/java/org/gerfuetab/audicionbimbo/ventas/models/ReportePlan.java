package org.gerfuetab.audicionbimbo.ventas.models;

import java.util.List;

public class ReportePlan {

	private String mensaje;
	private int codigo;
	private Double totalMonto;
	private List <ReportePlanCount> datos;
	
	
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
	public List<ReportePlanCount> getDatos() {
		return datos;
	}
	public void setDatos(List<ReportePlanCount> datos) {
		this.datos = datos;
	}
	public ReportePlan(String mensaje, int codigo, Double totalMonto, List<ReportePlanCount> datos) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.totalMonto = totalMonto;
		this.datos = datos;
	}
	public ReportePlan() {
		super();
	}
	public ReportePlan(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	
	
}
