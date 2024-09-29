package org.gerfuetab.audicionbimbo.ventas.models.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Embeddable
public class BitacoraRecargaPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -411774235756411858L;

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Size(max = 32)
    private UUID id;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "plan_id"), @JoinColumn(name = "proveedor_id") })
	private ProveedorPlan proveedorPlan;
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ProveedorPlan getProveedorPlan() {
		return proveedorPlan;
	}

	public void setProveedorPlan(ProveedorPlan proveedorPlan) {
		this.proveedorPlan = proveedorPlan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public BitacoraRecargaPK(UUID id, ProveedorPlan proveedorPlan) {
		super();
		this.id = id;
		this.proveedorPlan = proveedorPlan;
	}
	
	

	public BitacoraRecargaPK() {
		super();
	}

	
	
	public BitacoraRecargaPK(ProveedorPlan proveedorPlan) {
		super();
		this.proveedorPlan = proveedorPlan;
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
