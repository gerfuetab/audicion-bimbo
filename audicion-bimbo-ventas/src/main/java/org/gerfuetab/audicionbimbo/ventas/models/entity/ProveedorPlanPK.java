package org.gerfuetab.audicionbimbo.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProveedorPlanPK implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -411774235756411858L;
	
	@ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProveedorPlanPK(Proveedor proveedor, Plan plan) {
		super();
		this.proveedor = proveedor;
		this.plan = plan;
	}

	public ProveedorPlanPK() {
		super();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


    
    
    
	
}
