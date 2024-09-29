package org.gerfuetab.audicionbimbo.ventas.models;

import java.util.List;

public class ReporteProveedor {

	private String mensaje;
	private int codigo;
	private Double totalMonto;
	private List<ReporteProveedorCount> datos;

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

	public List<ReporteProveedorCount> getDatos() {
		return datos;
	}

	public void setDatos(List<ReporteProveedorCount> datos) {
		this.datos = datos;
	}

	public ReporteProveedor(String mensaje, int codigo, Double totalMonto, List<ReporteProveedorCount> datos) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.totalMonto = totalMonto;
		this.datos = datos;
	}

	public ReporteProveedor() {
		super();
	}

	public ReporteProveedor(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

}
