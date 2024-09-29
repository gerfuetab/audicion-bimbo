package org.gerfuetab.audicionbimbo.carrier.models;

public class Telefono {

    private String 	tipo;
    private String 	codigo_pais;
    private String 	codigo_area;
    private String 	prefijo;
    private String 	numero;
    private String extension;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigo_pais() {
		return codigo_pais;
	}
	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}
	public String getCodigo_area() {
		return codigo_area;
	}
	public void setCodigo_area(String codigo_area) {
		this.codigo_area = codigo_area;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public Telefono(String tipo, String codigo_pais, String codigo_area, String prefijo, String numero,
			String extension) {
		super();
		this.tipo = tipo;
		this.codigo_pais = codigo_pais;
		this.codigo_area = codigo_area;
		this.prefijo = prefijo;
		this.numero = numero;
		this.extension = extension;
	}
	public Telefono() {
		super();
	}
    
	
}
