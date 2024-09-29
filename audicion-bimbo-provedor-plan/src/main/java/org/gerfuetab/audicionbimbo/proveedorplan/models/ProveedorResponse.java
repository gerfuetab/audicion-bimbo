package org.gerfuetab.audicionbimbo.proveedorplan.models;



import java.util.List;

import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Proveedor;

public class ProveedorResponse {

    private int codigo;
    private String mensaje;   
    private List<Proveedor> proveedor;
	
    public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<Proveedor> getProveedor() {
		return proveedor;
	}
	public void setProveedor(List<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}
	public ProveedorResponse(int codigo, String mensaje, List<Proveedor> proveedor) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.proveedor = proveedor;
	}



}
