package org.gerfuetab.audicionbimbo.ventas.repositories;

import java.util.UUID;

import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;
import org.springframework.data.repository.CrudRepository;

public interface VentasRepository extends CrudRepository<BitacoraRecargas, UUID> {
   
}
