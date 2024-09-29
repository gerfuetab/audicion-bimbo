package org.gerfuetab.audicionbimbo.carrier.models;

import java.util.UUID;

public class CreaRecargaRequest {

    private Float 	monto;
    private Telefono 	telefono;
    private String 	metodoPago;
    private UUID token;
    private String 	tipo;
    private String tipoPaquete;
    private String idExterno;
    
    
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
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
	public String getIdExterno() {
		return idExterno;
	}
	public void setIdExterno(String idExterno) {
		this.idExterno = idExterno;
	}
	public CreaRecargaRequest(Float monto, Telefono telefono, String metodoPago, UUID token, String tipo,
			String tipoPaquete, String idExterno) {
		super();
		this.monto = monto;
		this.telefono = telefono;
		this.metodoPago = metodoPago;
		this.token = token;
		this.tipo = tipo;
		this.tipoPaquete = tipoPaquete;
		this.idExterno = idExterno;
	}
	public CreaRecargaRequest() {
		super();
	}
    
    
	
	
}
