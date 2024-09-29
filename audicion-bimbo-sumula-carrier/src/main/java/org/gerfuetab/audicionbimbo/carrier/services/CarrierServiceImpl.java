package org.gerfuetab.audicionbimbo.carrier.services;

import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.Recarga;
import org.gerfuetab.audicionbimbo.carrier.models.Tarjeta;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

@Service
public class CarrierServiceImpl implements CarrierService {

	@Override
	public UUID obtenerTokenTarjeta(Tarjeta tarjeta) {

		/*
		 * 1.- Simulación de cracion de token por la tarejta ingresada 2.-No se
		 * generarael token ni se persistira en BD por estar fuera de alance segun lo
		 * que se requiere por que esto lo realiza cada proveedor en su sistema
		 * realmente.
		 */

		UUID token = UUID.randomUUID();
		return token;

	}

	@Override
	public Boolean validaTokenTarjeta(UUID token) {

		/*
		 * 1.- Simulación de validacion de TOKEN 2.-No se valida token ni se recupera de
		 * BD por estar fuera de alance segun lo que se requiere por que esto lo realiza
		 * cada proveedor en su sistema realmente.
		 */

		if (token == null)
			return false;
		else
			return true;

	}

	@Override
	public CreaRecargaResponse crearRecarga(CreaRecargaRequest creaRecargaRequest) throws ParseException {
		/*
		 * 1.-Simulación de cracion de recarga ante las APIS de los proveedores 2.-No se
		 * registra la recarga ni se persiste por que esto lo realiza cada proveedor en
		 * su sistema realmente.
		 */
		Random rand = new Random();
		SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy' 'HH:mm:ss");
		isoFormat.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		String fecha=isoFormat.format( Calendar.getInstance().getTime());
		CreaRecargaResponse recarga = new CreaRecargaResponse("success",
				new Recarga(UUID.randomUUID().toString(), creaRecargaRequest.getMonto(), creaRecargaRequest.getTipo(),
						creaRecargaRequest.getTipoPaquete(), "aprobada", creaRecargaRequest.getMetodoPago(),
						creaRecargaRequest.getToken().toString(), String.valueOf(rand.nextInt(1000)), String.valueOf(rand.nextInt(1000)),
						creaRecargaRequest.getTelefono(), fecha, fecha),
				210);
		return recarga;

	}

	/*
	 * @Override
	 * 
	 * @Transactional public Usuario guardar(Usuario usuario) { return
	 * repository.save(usuario); }
	 */
}
