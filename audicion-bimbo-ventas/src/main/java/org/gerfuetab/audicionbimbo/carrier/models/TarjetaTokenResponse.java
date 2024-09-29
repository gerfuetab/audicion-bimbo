package org.gerfuetab.audicionbimbo.carrier.models;

import java.util.UUID;

public class TarjetaTokenResponse {

    private String 	mensaje;
    private UUID token;
    private int codigo;
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public TarjetaTokenResponse(String mensaje, UUID token, int codigo) {
		super();
		this.mensaje = mensaje;
		this.token = token;
		this.codigo = codigo;
	}
	public TarjetaTokenResponse(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	public TarjetaTokenResponse() {
		super();
	}
    
    
}
