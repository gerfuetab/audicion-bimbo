package org.gerfuetab.audicionbimbo.carrier.services;

import java.text.ParseException;
import java.util.UUID;

import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.Tarjeta;

public interface CarrierService {
	
	UUID obtenerTokenTarjeta(Tarjeta tarjeta);
	
	Boolean validaTokenTarjeta(UUID token);

	CreaRecargaResponse crearRecarga(CreaRecargaRequest creaRecargaRequest)  throws ParseException;
}
