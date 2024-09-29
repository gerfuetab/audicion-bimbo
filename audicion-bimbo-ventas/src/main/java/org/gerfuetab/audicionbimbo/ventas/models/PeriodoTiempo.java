package org.gerfuetab.audicionbimbo.ventas.models;


public class PeriodoTiempo {

	private String momentoInicial;
	private String momentoFinal;
	private String numero;
	private Long planId;
	
	public String getMomentoInicial() {
		return momentoInicial;
	}
	public void setMomentoInicial(String momentoInicial) {
		this.momentoInicial = momentoInicial;
	}
	public String getMomentoFinal() {
		return momentoFinal;
	}
	public void setMomentoFinal(String momentoFinal) {
		this.momentoFinal = momentoFinal;
	}
	public PeriodoTiempo(String momentoInicial, String momentoFinal) {
		super();
		this.momentoInicial = momentoInicial;
		this.momentoFinal = momentoFinal;
	}
	public PeriodoTiempo() {
		super();
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public PeriodoTiempo(String momentoInicial, String momentoFinal, String numero) {
		super();
		this.momentoInicial = momentoInicial;
		this.momentoFinal = momentoFinal;
		this.numero = numero;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public PeriodoTiempo(String momentoInicial, String momentoFinal, String numero, Long planId) {
		super();
		this.momentoInicial = momentoInicial;
		this.momentoFinal = momentoFinal;
		this.numero = numero;
		this.planId = planId;
	}


	



}
