package org.gerfuetab.audicionbimbo.carrier.models;


public class RealizaRecargaRequest {

    private Telefono 	telefono;
    private String 	metodoPago;
    private Tarjeta tarjeta;
    private String 	tipo;
    private String tipoPaquete;
    private String idExterno;
    private Long proveedor_id;
    private Long plan_id;
    
   
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
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
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
	public Long getProveedor_id() {
		return proveedor_id;
	}
	public void setProveedor_id(Long proveedor_id) {
		this.proveedor_id = proveedor_id;
	}
	public Long getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Long plan_id) {
		this.plan_id = plan_id;
	}
	public RealizaRecargaRequest( Telefono telefono, String metodoPago, Tarjeta tarjeta, String tipo,
			String tipoPaquete, String idExterno, Long proveedor_id, Long plan_id) {
		super();
		
		this.telefono = telefono;
		this.metodoPago = metodoPago;
		this.tarjeta = tarjeta;
		this.tipo = tipo;
		this.tipoPaquete = tipoPaquete;
		this.idExterno = idExterno;
		this.proveedor_id = proveedor_id;
		this.plan_id = plan_id;
	}
	public RealizaRecargaRequest() {
		super();
	}


	
	
    
   
    
	
	
}
