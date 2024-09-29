package org.gerfuetab.audicionbimbo.ventas.clients;

import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaRequest;
import org.gerfuetab.audicionbimbo.carrier.models.CreaRecargaResponse;
import org.gerfuetab.audicionbimbo.carrier.models.Tarjeta;
import org.gerfuetab.audicionbimbo.carrier.models.TarjetaTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="carrierClient", url = "${api.proveedor.host}")
public interface CarrierClienteRest {

	@PostMapping("/carrier/tarjetaToken")
	TarjetaTokenResponse obtenerTokenTarjeta(@RequestBody  Tarjeta tarjeta);
	
	@PostMapping("{urlProveedor}")
	CreaRecargaResponse creaRecargaTelcel(@RequestBody  CreaRecargaRequest creaRecargaRequest, @PathVariable("urlProveedor") String urlProveedor);
}
