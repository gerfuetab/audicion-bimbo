package org.gerfuetab.audicionbimbo.ventas.models.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="bitacora_recargas")
public class BitacoraRecargas {

    @EmbeddedId
    private BitacoraRecargaPK bitacoraRecargaPK;

    @NotBlank
    private String id_transacion_carrier; 
    
    @NotBlank
    private String numAutorizacionPago;
    
    @NotBlank
    private String numAutorizacionPaquete;
    
    @NotNull(message = "Please enter monto")
    private Float 	monto;
    
    @NotBlank
    private String 	codigo_pais;
    @NotBlank
    private String 	codigo_area;
    @NotBlank
    private String 	prefijo;
    @NotBlank
    private String 	numero;
  
    @NotNull(message = "Please enter fecha_transaccion")
    @CreationTimestamp
    private LocalDateTime fecha_transaccion;

	public BitacoraRecargaPK getBitacoraRecargaPK() {
		return bitacoraRecargaPK;
	}

	public void setBitacoraRecargaPK(BitacoraRecargaPK bitacoraRecargaPK) {
		this.bitacoraRecargaPK = bitacoraRecargaPK;
	}

	public String getId_transacion_carrier() {
		return id_transacion_carrier;
	}

	public void setId_transacion_carrier(String id_transacion_carrier) {
		this.id_transacion_carrier = id_transacion_carrier;
	}

	public String getNumAutorizacionPago() {
		return numAutorizacionPago;
	}

	public void setNumAutorizacionPago(String numAutorizacionPago) {
		this.numAutorizacionPago = numAutorizacionPago;
	}

	public String getNumAutorizacionPaquete() {
		return numAutorizacionPaquete;
	}

	public void setNumAutorizacionPaquete(String numAutorizacionPaquete) {
		this.numAutorizacionPaquete = numAutorizacionPaquete;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getCodigo_pais() {
		return codigo_pais;
	}

	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}

	public String getCodigo_area() {
		return codigo_area;
	}

	public void setCodigo_area(String codigo_area) {
		this.codigo_area = codigo_area;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha_transaccion() {
		return fecha_transaccion;
	}

	public void setFecha_transaccion(LocalDateTime fecha_transaccion) {
		this.fecha_transaccion = fecha_transaccion;
	}

	public BitacoraRecargas(BitacoraRecargaPK bitacoraRecargaPK, @NotBlank String id_transacion_carrier,
			@NotBlank String numAutorizacionPago, @NotBlank String numAutorizacionPaquete, @NotBlank Float monto,
			@NotBlank String codigo_pais, @NotBlank String codigo_area, @NotBlank String prefijo,
			@NotBlank String numero, @NotBlank LocalDateTime fecha_transaccion) {
		super();
		this.bitacoraRecargaPK = bitacoraRecargaPK;
		this.id_transacion_carrier = id_transacion_carrier;
		this.numAutorizacionPago = numAutorizacionPago;
		this.numAutorizacionPaquete = numAutorizacionPaquete;
		this.monto = monto;
		this.codigo_pais = codigo_pais;
		this.codigo_area = codigo_area;
		this.prefijo = prefijo;
		this.numero = numero;
		this.fecha_transaccion = fecha_transaccion;
	}

	public BitacoraRecargas() {
		super();
	}
    
   
}
