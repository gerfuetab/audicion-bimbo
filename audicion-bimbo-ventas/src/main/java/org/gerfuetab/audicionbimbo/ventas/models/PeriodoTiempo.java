package org.gerfuetab.audicionbimbo.ventas.models;


public class PeriodoTiempo {

	private String momentoInicial;
	private String momentoFinal;
	
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




}
