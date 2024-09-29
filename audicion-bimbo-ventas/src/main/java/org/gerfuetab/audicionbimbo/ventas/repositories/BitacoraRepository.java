package org.gerfuetab.audicionbimbo.ventas.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.gerfuetab.audicionbimbo.ventas.models.ReportePlanCount;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorCount;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlanCount;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargaPK;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BitacoraRepository extends CrudRepository<BitacoraRecargas, BitacoraRecargaPK> {
    
    /*@Query(value="select * from bitacora_recargas  where numero=?1 and proveedor_id=?2 and plan_id=?3  order by fecha_transaccion desc limit 0,1", nativeQuery = true)*/
	@Query("select u from BitacoraRecargas u where u.numero=?1 and u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor.proveedor_id=?2 and u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan.plan_id=?3 and (TIMESTAMPDIFF(MINUTE,u.fecha_transaccion,CONVERT_TZ(now(),'UTC','America/Mexico_City')) BETWEEN 0 AND 15 )")
	List<BitacoraRecargas> validaMismaTransaccion(String numero,Long proveedor_id, Long plan_id);
    
	@Query("select u from BitacoraRecargas u where DATE(u.fecha_transaccion)= DATE(CONVERT_TZ(now(),'UTC','America/Mexico_City')) ")
	List<BitacoraRecargas> reporteVentasDiario();
	
	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReportePlanCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan, count(u),sum (u.monto)) from BitacoraRecargas u where DATE(u.fecha_transaccion)= DATE(CONVERT_TZ(now(),'UTC','America/Mexico_City')) GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan ORDER BY count(u) DESC")
	List<ReportePlanCount> reportePlanDiario();
	
	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, count(u),sum (u.monto)) from BitacoraRecargas u where DATE(u.fecha_transaccion)= DATE(CONVERT_TZ(now(),'UTC','America/Mexico_City')) GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor ORDER BY count(u) DESC")
	List<ReporteProveedorCount> reporteProveedorDiario();
	
	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlanCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan, count(u),sum(u.monto)) from BitacoraRecargas u where DATE(u.fecha_transaccion)= DATE(CONVERT_TZ(now(),'UTC','America/Mexico_City')) GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan ORDER BY count(u) DESC")
	List<ReporteProveedorPlanCount> reporteProveedorPlanDiario();
	
	/*List<BitacoraRecargas> findByDateCreatedBetween(Date startDate, Date endDate);*/
	
	@Query("select u from BitacoraRecargas u where u.fecha_transaccion between :momentoInicial and :momentoFinal")
	List<BitacoraRecargas> reporteVentas( @Param("momentoInicial") LocalDateTime momentoInicial, @Param("momentoFinal") LocalDateTime momentoFinal);
	
	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReportePlanCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan, count(u),sum(u.monto)) from BitacoraRecargas u where u.fecha_transaccion between :momentoInicial and :momentoFinal GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan ORDER BY count(u) DESC")
	List<ReportePlanCount> reportePlan(@Param("momentoInicial") LocalDateTime momentoInicial, @Param("momentoFinal") LocalDateTime momentoFinal);
	
	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, count(u),sum(u.monto)) from BitacoraRecargas u where u.fecha_transaccion between :momentoInicial and :momentoFinal GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor ORDER BY count(u) DESC")
	List<ReporteProveedorCount> reporteProveedor(@Param("momentoInicial") LocalDateTime momentoInicial, @Param("momentoFinal") LocalDateTime momentoFinal);

	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlanCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan, count(u),sum(u.monto)) from BitacoraRecargas u where u.fecha_transaccion between :momentoInicial and :momentoFinal GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan ORDER BY count(u) DESC")
	List<ReporteProveedorPlanCount> reporteProveedorPlan(@Param("momentoInicial") LocalDateTime momentoInicial, @Param("momentoFinal") LocalDateTime momentoFinal);;

	@Query("select u from BitacoraRecargas u where u.numero =:numero and u.fecha_transaccion between :momentoInicial and :momentoFinal")
	List<BitacoraRecargas> reporteVentasNumero(@Param("numero") String numero, @Param("momentoInicial") LocalDateTime momentoInicial, @Param("momentoFinal") LocalDateTime momentoFinal);
	
	@Query("select new org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorCount( u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor, count(u),sum(u.monto)) from BitacoraRecargas u where u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.plan.plan_id=:planID and u.fecha_transaccion between :momentoInicial and :momentoFinal GROUP BY u.bitacoraRecargaPK.proveedorPlan.proveedorPlanPK.proveedor ORDER BY count(u) DESC")
	List<ReporteProveedorCount> reporteProveedorPlanID(@Param("planID") Long planID,@Param("momentoInicial") LocalDateTime momentoInicial, @Param("momentoFinal") LocalDateTime momentoFinal);


}


