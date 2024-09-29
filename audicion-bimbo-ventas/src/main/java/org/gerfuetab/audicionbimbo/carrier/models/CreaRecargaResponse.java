package org.gerfuetab.audicionbimbo.carrier.models;

public class CreaRecargaResponse {

    private String 	mensaje;
    private Recarga recarga;
    private int codigo;
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Recarga getRecarga() {
		return recarga;
	}
	public void setRecarga(Recarga recarga) {
		this.recarga = recarga;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public CreaRecargaResponse(String mensaje, Recarga recarga, int codigo) {
		super();
		this.mensaje = mensaje;
		this.recarga = recarga;
		this.codigo = codigo;
	}
	public CreaRecargaResponse(String mensaje, int codigo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	public CreaRecargaResponse() {
		super();
	}
   
	
}
