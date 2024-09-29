package org.gerfuetab.audicionbimbo.proveedorplan.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "proveedor_plan")
public class ProveedorPlan {

    @EmbeddedId
    private ProveedorPlanPK proveedorPlanPK;

	public ProveedorPlanPK getProveedorPlanPK() {
		return proveedorPlanPK;
	}

	public void setProveedorPlanPK(ProveedorPlanPK proveedorPlanPK) {
		this.proveedorPlanPK = proveedorPlanPK;
	}

	public ProveedorPlan(ProveedorPlanPK proveedorPlanPK) {
		super();
		this.proveedorPlanPK = proveedorPlanPK;
	}

	public ProveedorPlan() {
		super();
	}

    
}
