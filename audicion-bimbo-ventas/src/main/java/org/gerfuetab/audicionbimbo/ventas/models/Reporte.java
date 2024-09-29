package org.gerfuetab.audicionbimbo.ventas.models;

import java.util.List;

import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;

public class Reporte {

	private String mensaje;
	private int codigo;
	private int totalRegistros;
	private Float totalMonto;
	List<BitacoraRecargas> ventas;

	public int getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public Float getTotalMonto() {
		return totalMonto;
	}

	public void setTotalMonto(Float totalMonto) {
		this.totalMonto = totalMonto;
	}

	public List<BitacoraRecargas> getVentas() {
		return ventas;
	}

	public void setVentas(List<BitacoraRecargas> ventas) {
		this.ventas = ventas;
	}

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

	public Reporte(String mensaje, int codigo, int totalRegistros, Float totalMonto, List<BitacoraRecargas> ventas) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.totalRegistros = totalRegistros;
		this.totalMonto = totalMonto;
		this.ventas = ventas;
	}

	public Reporte() {
		super();
	}

	public Reporte(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	
}
