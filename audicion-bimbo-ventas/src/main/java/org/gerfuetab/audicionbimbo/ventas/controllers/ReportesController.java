package org.gerfuetab.audicionbimbo.ventas.controllers;

import javax.validation.Valid;

import org.gerfuetab.audicionbimbo.ventas.models.PeriodoTiempo;
import org.gerfuetab.audicionbimbo.ventas.models.Reporte;
import org.gerfuetab.audicionbimbo.ventas.models.ReportePlan;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedor;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlan;
import org.gerfuetab.audicionbimbo.ventas.services.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportesController {

	@Autowired
	private ReportesService service;

	@CrossOrigin
	@GetMapping("/reportes/reporteVentasDiario")
	public ResponseEntity<Reporte> reporteVentasDiario() {
		Reporte reporte = service.reporteVentasDiario();
		if (reporte == null) {
			return ResponseEntity.ok(new Reporte("Reporte no generado", 220));
		}
		return ResponseEntity.ok(reporte);

	}

	@CrossOrigin
	@GetMapping("/reportes/reportePlanDiario")
	public ResponseEntity<ReportePlan> reportePlanDiario() {
		return ResponseEntity.ok(service.reportePlanDiario());

	}

	@CrossOrigin
	@GetMapping("/reportes/reporteProveedorDiario")
	public ResponseEntity<ReporteProveedor> reporteProveedorDiario() {
		return ResponseEntity.ok(service.reporteProveedorDiario());

	}

	@CrossOrigin
	@GetMapping("/reportes/reporteProveedorPlanDiario")
	public ResponseEntity<ReporteProveedorPlan> reporteProveedorPlanDiario() {
		return ResponseEntity.ok(service.reporteProveedorPlanDiario());

	}

	@PostMapping("/reportes/reporteVentas")
	public ResponseEntity<Reporte> reporteVentas(@Valid @RequestBody PeriodoTiempo periodoTiempo) {
		Reporte reporte = service.reporteVentas(periodoTiempo);
		if (reporte == null) {
			return ResponseEntity.ok(new Reporte("Reporte no generado", 220));
		}
		return ResponseEntity.ok(reporte);

	}
	
	@PostMapping("/reportes/reporteProveedor")
	public ResponseEntity<ReporteProveedor> reporteProveedor(@Valid @RequestBody PeriodoTiempo periodoTiempo) {
		return ResponseEntity.ok(service.reporteProveedor(periodoTiempo));

	}

	@PostMapping("/reportes/reportePlan")
	public ResponseEntity<ReportePlan	> reportePlan(@Valid @RequestBody PeriodoTiempo periodoTiempo) {
		return ResponseEntity.ok(service.reportePlan(periodoTiempo));

	}
	
	@PostMapping("/reportes/reporteProveedorPlan")
	public ResponseEntity<ReporteProveedorPlan	> reporteProveedorPlan(@Valid @RequestBody PeriodoTiempo periodoTiempo) {
		return ResponseEntity.ok(service.reporteProveedorPlan(periodoTiempo));

	}
	
	@PostMapping("/reportes/reporteVentasNumero")
	public ResponseEntity<Reporte> reporteVentasNumero(@Valid @RequestBody PeriodoTiempo periodoTiempo) {
		Reporte reporte = service.reporteVentasNumero(periodoTiempo);
		if (reporte == null) {
			return ResponseEntity.ok(new Reporte("Reporte no generado", 220));
		}
		return ResponseEntity.ok(reporte);

	}
	
	@PostMapping("/reportes/reporteProveedorPlanId")
	public ResponseEntity<ReporteProveedor> reporteProveedorPlanId(@Valid @RequestBody PeriodoTiempo periodoTiempo) {
		return ResponseEntity.ok(service.reporteProveedorPlanID(periodoTiempo));

	}
}
