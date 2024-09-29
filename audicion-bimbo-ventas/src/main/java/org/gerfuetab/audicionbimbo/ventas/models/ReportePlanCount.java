package org.gerfuetab.audicionbimbo.ventas.models;

import org.gerfuetab.audicionbimbo.ventas.models.entity.Plan;

public class ReportePlanCount {

	private Plan plan;
	private Long totalRegistros;
	private Double totalMonto;

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Long getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(Long totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public ReportePlanCount(Plan plan, Long totalRegistros) {
		super();
		this.plan = plan;
		this.totalRegistros = totalRegistros;
	}

	public ReportePlanCount() {
		super();
	}

	public Double getTotalMonto() {
		return totalMonto;
	}

	public void setTotalMonto(Double totalMonto) {
		this.totalMonto = totalMonto;
	}

	public ReportePlanCount(Plan plan, Long totalRegistros, Double totalMonto) {
		super();
		this.plan = plan;
		this.totalRegistros = totalRegistros;
		this.totalMonto = totalMonto;
	}

}
