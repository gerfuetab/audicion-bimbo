package org.gerfuetab.audicionbimbo.carrier.controllers;

import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.Tarjeta;
import org.gerfuetab.audicionbimbo.carrier.models.TarjetaTokenResponse;
import org.gerfuetab.audicionbimbo.carrier.services.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.text.ParseException;
import java.util.*;

@RestController
public class CarrierController {

	@Autowired
	private CarrierService serviceCarrier;

	@PostMapping("/carrier/tarjetaToken")
	public ResponseEntity<TarjetaTokenResponse> crearRecargaTelcel(@Valid @RequestBody Tarjeta tarjeta) {

		UUID token = serviceCarrier.obtenerTokenTarjeta(tarjeta);
		if (token == null) {
			return ResponseEntity
					.ok(new TarjetaTokenResponse("No se pudo crear token con la tarjeta proporcionada", 220));
		}
		return ResponseEntity.ok(new TarjetaTokenResponse("Token para tajeta generado correctamente", token, 210));

	}

	@PostMapping("/carrier/telcel/CreaRecarga")
	public ResponseEntity<CreaRecargaResponse> crearRecargaTelcel(
			@Valid @RequestBody CreaRecargaRequest creaRecargaRequest) throws ParseException {

		if (!serviceCarrier.validaTokenTarjeta(creaRecargaRequest.getToken())) {
			return ResponseEntity.ok(new CreaRecargaResponse("Token de tarjeta no valido", 220));
		}
		CreaRecargaResponse cargaResponse = serviceCarrier.crearRecarga(creaRecargaRequest);
		return ResponseEntity.ok(cargaResponse);

	}

	@PostMapping("/carrier/movistar/CreaRecarga")
	public ResponseEntity<CreaRecargaResponse> crearRecargaMovistar(
			@Valid @RequestBody CreaRecargaRequest creaRecargaRequest) throws ParseException {

		if (!serviceCarrier.validaTokenTarjeta(creaRecargaRequest.getToken())) {
			return ResponseEntity.ok(new CreaRecargaResponse("Token de tarjeta no valido", 220));
		}
		CreaRecargaResponse cargaResponse = serviceCarrier.crearRecarga(creaRecargaRequest);
		return ResponseEntity.ok(cargaResponse);

	}

	@PostMapping("/carrier/att/CreaRecarga")
	public ResponseEntity<CreaRecargaResponse> crearRecargaAtt(
			@Valid @RequestBody CreaRecargaRequest creaRecargaRequest) throws ParseException {

		if (!serviceCarrier.validaTokenTarjeta(creaRecargaRequest.getToken())) {
			return ResponseEntity.ok(new CreaRecargaResponse("Token de tarjeta no valido", 220));
		}
		CreaRecargaResponse cargaResponse = serviceCarrier.crearRecarga(creaRecargaRequest);
		return ResponseEntity.ok(cargaResponse);

	}
	
	@PostMapping("/carrier/unefon/CreaRecarga")
	public ResponseEntity<CreaRecargaResponse> crearRecargaUnefon(
			@Valid @RequestBody CreaRecargaRequest creaRecargaRequest)  throws ParseException{

		if (!serviceCarrier.validaTokenTarjeta(creaRecargaRequest.getToken())) {
			return ResponseEntity.ok(new CreaRecargaResponse("Token de tarjeta no valido", 220));
		}
		CreaRecargaResponse cargaResponse = serviceCarrier.crearRecarga(creaRecargaRequest);
		return ResponseEntity.ok(cargaResponse);

	}

	@PostMapping("/carrier/bait/CreaRecarga")
	public ResponseEntity<CreaRecargaResponse> crearRecargaBait(
			@Valid @RequestBody CreaRecargaRequest creaRecargaRequest)  throws ParseException{

		if (!serviceCarrier.validaTokenTarjeta(creaRecargaRequest.getToken())) {
			return ResponseEntity.ok(new CreaRecargaResponse("Token de tarjeta no valido", 220));
		}
		CreaRecargaResponse cargaResponse = serviceCarrier.crearRecarga(creaRecargaRequest);
		return ResponseEntity.ok(cargaResponse);

	}

}
