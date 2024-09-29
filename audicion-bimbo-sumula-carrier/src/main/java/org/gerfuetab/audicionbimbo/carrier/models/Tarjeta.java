package org.gerfuetab.audicionbimbo.carrier.models;

public class Tarjeta {

    private String 	nombreTitular;
    private String 	pan;
    private String 	expiracion_mes;
    private String 	expiracion_anio;
    private String 	cvv2;
    private Boolean _default;
    
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getExpiracion_mes() {
		return expiracion_mes;
	}
	public void setExpiracion_mes(String expiracion_mes) {
		this.expiracion_mes = expiracion_mes;
	}
	public String getExpiracion_anio() {
		return expiracion_anio;
	}
	public void setExpiracion_anio(String expiracion_anio) {
		this.expiracion_anio = expiracion_anio;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public Boolean get_default() {
		return _default;
	}
	public void set_default(Boolean _default) {
		this._default = _default;
	}
	public Tarjeta(String nombreTitular, String pan, String expiracion_mes, String expiracion_anio, String cvv2,
			Boolean _default) {
		super();
		this.nombreTitular = nombreTitular;
		this.pan = pan;
		this.expiracion_mes = expiracion_mes;
		this.expiracion_anio = expiracion_anio;
		this.cvv2 = cvv2;
		this._default = _default;
	}
	public Tarjeta() {
		super();
	}
	
	
}
