package org.gerfuetab.audicionbimbo.proveedorplan.models.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proveedor_id;

    @NotEmpty
    private String nombreProveedor;
    
    @NotEmpty
    private String url;
    
    @NotEmpty
    private String logo;
    
    @NotEmpty
    private Boolean ativo;

	public Long getProveedor_id() {
		return proveedor_id;
	}

	public void setProveedor_id(Long proveedor_id) {
		this.proveedor_id = proveedor_id;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Proveedor(Long proveedor_id, @NotEmpty String nombreProveedor, @NotEmpty String url, @NotEmpty String logo,
			@NotEmpty Boolean ativo) {
		super();
		this.proveedor_id = proveedor_id;
		this.nombreProveedor = nombreProveedor;
		this.url = url;
		this.logo = logo;
		this.ativo = ativo;
	}

	public Proveedor() {
		super();
	}
    

 
}
