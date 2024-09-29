package org.gerfuetab.audicionbimbo.ventas.models.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plan_id;

    @NotBlank
    private String nombrePlan;

    @NotBlank
    private String descripcion;

    @NotBlank
    private Float precio;

	public Long getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Long plan_id) {
		this.plan_id = plan_id;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Plan(Long plan_id, @NotBlank String nombrePlan, @NotBlank String descripcion, @NotBlank Float precio) {
		super();
		this.plan_id = plan_id;
		this.nombrePlan = nombrePlan;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Plan() {
		super();
	}

	public Plan(Long plan_id) {
		super();
		this.plan_id = plan_id;
	}



}
