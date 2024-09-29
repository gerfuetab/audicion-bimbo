package org.gerfuetab.audicionbimbo.carrier.models;

public class Recarga {

    private String 	id;
    private Float 	monto;
    private String 	tipo;
    private String 	tipoPaquete;
    private String 	estado;
    private String 	metodoPago;
    private String metodoPagoToken;
    private String numeroAutorizacionPago;
    private String numeroAutorizacionPaquete;
    private Telefono telefono;
    private String  creacion;
    private String actualizacion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getMetodoPagoToken() {
		return metodoPagoToken;
	}
	public void setMetodoPagoToken(String metodoPagoToken) {
		this.metodoPagoToken = metodoPagoToken;
	}
	public String getNumeroAutorizacionPago() {
		return numeroAutorizacionPago;
	}
	public void setNumeroAutorizacionPago(String numeroAutorizacionPago) {
		this.numeroAutorizacionPago = numeroAutorizacionPago;
	}
	public String getNumeroAutorizacionPaquete() {
		return numeroAutorizacionPaquete;
	}
	public void setNumeroAutorizacionPaquete(String numeroAutorizacionPaquete) {
		this.numeroAutorizacionPaquete = numeroAutorizacionPaquete;
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public String getCreacion() {
		return creacion;
	}
	public void setCreacion(String creacion) {
		this.creacion = creacion;
	}
	public String getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(String actualizacion) {
		this.actualizacion = actualizacion;
	}
	public Recarga(String id, Float monto, String tipo, String tipoPaquete, String estado, String metodoPago,
			String metodoPagoToken, String numeroAutorizacionPago, String numeroAutorizacionPaquete, Telefono telefono,
			String creacion, String actualizacion) {
		super();
		this.id = id;
		this.monto = monto;
		this.tipo = tipo;
		this.tipoPaquete = tipoPaquete;
		this.estado = estado;
		this.metodoPago = metodoPago;
		this.metodoPagoToken = metodoPagoToken;
		this.numeroAutorizacionPago = numeroAutorizacionPago;
		this.numeroAutorizacionPaquete = numeroAutorizacionPaquete;
		this.telefono = telefono;
		this.creacion = creacion;
		this.actualizacion = actualizacion;
	}
	public Recarga() {
		super();
	}
    
    
    
    
	
}
