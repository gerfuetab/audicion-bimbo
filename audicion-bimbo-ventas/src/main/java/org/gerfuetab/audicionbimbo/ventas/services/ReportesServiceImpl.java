package org.gerfuetab.audicionbimbo.ventas.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.gerfuetab.audicionbimbo.ventas.models.PeriodoTiempo;
import org.gerfuetab.audicionbimbo.ventas.models.Reporte;
import org.gerfuetab.audicionbimbo.ventas.models.ReportePlan;
import org.gerfuetab.audicionbimbo.ventas.models.ReportePlanCount;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedor;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorCount;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlan;
import org.gerfuetab.audicionbimbo.ventas.models.ReporteProveedorPlanCount;
import org.gerfuetab.audicionbimbo.ventas.models.entity.BitacoraRecargas;
import org.gerfuetab.audicionbimbo.ventas.repositories.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportesServiceImpl implements ReportesService {

	@Autowired
	private BitacoraRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Reporte reporteVentasDiario() {

		List<BitacoraRecargas> registros = repository.reporteVentasDiario();
		Float totalMonto = (float) 0;
		for (BitacoraRecargas registro : registros) {
			totalMonto = totalMonto + registro.getMonto();
			registro.getBitacoraRecargaPK().getProveedorPlan().getProveedorPlanPK().getProveedor().setUrl(null);
		}
		Reporte reporte = new Reporte("Reporte generado", 210, registros.size(), totalMonto, registros);
		return reporte;
	}

	@Override
	@Transactional(readOnly = true)
	public ReportePlan reportePlanDiario() {
		List<ReportePlanCount> registros = repository.reportePlanDiario();
		if (registros == null) {
			return new ReportePlan("Reporte no generado", 220);
		}
		Double totalMonto = (double) 0;
		for (ReportePlanCount registro : registros) {
			totalMonto = totalMonto + registro.getTotalMonto();
		}
		return new ReportePlan("Reporte generado", 210, totalMonto, registros);
	}

	@Override
	@Transactional(readOnly = true)
	public ReporteProveedor reporteProveedorDiario() {
		List<ReporteProveedorCount> registros = repository.reporteProveedorDiario();
		if (registros == null) {
			return new ReporteProveedor("Reporte no generado", 220);
		}
		Double totalMonto = (double) 0;
		for (ReporteProveedorCount registro : registros) {
			totalMonto = totalMonto + registro.getTotalMonto();
		}
		return new ReporteProveedor("Reporte generado", 210, totalMonto, registros);
	}

	@Override
	@Transactional(readOnly = true)
	public ReporteProveedorPlan reporteProveedorPlanDiario() {
		List<ReporteProveedorPlanCount> registros = repository.reporteProveedorPlanDiario();
		if (registros == null) {
			return new ReporteProveedorPlan("Reporte no generado", 220);
		}
		Double totalMonto = (double) 0;
		for (ReporteProveedorPlanCount registro : registros) {
			totalMonto = totalMonto + registro.getTotalMonto();
		}
		return new ReporteProveedorPlan("Reporte generado", 210, totalMonto, registros);
	}

	@Override
	@Transactional(readOnly = true)
	public Reporte reporteVentas(PeriodoTiempo periodoTiempo) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.parse(periodoTiempo.getMomentoInicial(), formatter);
			LocalDateTime fin = LocalDateTime.parse(periodoTiempo.getMomentoFinal(), formatter);
			List<BitacoraRecargas> registros = repository.reporteVentas(inicio, fin);
			Float totalMonto = (float) 0;
			for (BitacoraRecargas registro : registros) {
				totalMonto = totalMonto + registro.getMonto();
				registro.getBitacoraRecargaPK().getProveedorPlan().getProveedorPlanPK().getProveedor().setUrl(null);
			}
			Reporte reporte = new Reporte("Reporte generado", 210, registros.size(), totalMonto, registros);
			return reporte;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			Reporte reporte = new Reporte("Reporte no generado", 220);
			return reporte;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ReportePlan reportePlan(PeriodoTiempo periodoTiempo) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.parse(periodoTiempo.getMomentoInicial(), formatter);
			LocalDateTime fin = LocalDateTime.parse(periodoTiempo.getMomentoFinal(), formatter);
			List<ReportePlanCount> registros = repository.reportePlan(inicio, fin);
			if (registros == null) {
				return new ReportePlan("Reporte no generado", 220);
			}
			Double totalMonto = (double) 0;
			for (ReportePlanCount registro : registros) {
				totalMonto = totalMonto + registro.getTotalMonto();
			}
			return new ReportePlan("Reporte generado", 210, totalMonto, registros);
		} catch (Exception ex) {

			return new ReportePlan("Reporte no generado", 230);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ReporteProveedor reporteProveedor(PeriodoTiempo periodoTiempo) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.parse(periodoTiempo.getMomentoInicial(), formatter);
			LocalDateTime fin = LocalDateTime.parse(periodoTiempo.getMomentoFinal(), formatter);
			List<ReporteProveedorCount> registros = repository.reporteProveedor(inicio, fin);
			if (registros == null) {
				return new ReporteProveedor("Reporte no generado", 220);
			}
			Double totalMonto = (double) 0;
			for (ReporteProveedorCount registro : registros) {
				totalMonto = totalMonto + registro.getTotalMonto();
			}
			return new ReporteProveedor("Reporte generado", 210, totalMonto, registros);
		} catch (Exception ex) {

			return new ReporteProveedor("Reporte no generado", 230);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ReporteProveedorPlan reporteProveedorPlan(PeriodoTiempo periodoTiempo) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.parse(periodoTiempo.getMomentoInicial(), formatter);
			LocalDateTime fin = LocalDateTime.parse(periodoTiempo.getMomentoFinal(), formatter);
			List<ReporteProveedorPlanCount> registros = repository.reporteProveedorPlan(inicio, fin);
			if (registros == null) {
				return new ReporteProveedorPlan("Reporte no generado", 220);
			}
			Double totalMonto = (double) 0;
			for (ReporteProveedorPlanCount registro : registros) {
				totalMonto = totalMonto + registro.getTotalMonto();
			}
			return new ReporteProveedorPlan("Reporte generado", 210, totalMonto, registros);
		} catch (Exception ex) {

			return new ReporteProveedorPlan("Reporte no generado", 230);
		}
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Reporte reporteVentasNumero(PeriodoTiempo periodoTiempo) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.parse(periodoTiempo.getMomentoInicial(), formatter);
			LocalDateTime fin = LocalDateTime.parse(periodoTiempo.getMomentoFinal(), formatter);
			List<BitacoraRecargas> registros = repository.reporteVentasNumero(periodoTiempo.getNumero(),inicio, fin);
			Float totalMonto = (float) 0;
			for (BitacoraRecargas registro : registros) {
				totalMonto = totalMonto + registro.getMonto();
				registro.getBitacoraRecargaPK().getProveedorPlan().getProveedorPlanPK().getProveedor().setUrl(null);
			}
			Reporte reporte = new Reporte("Reporte generado", 210, registros.size(), totalMonto, registros);
			return reporte;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			Reporte reporte = new Reporte("Reporte no generado", 220);
			return reporte;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public ReporteProveedor reporteProveedorPlanID(PeriodoTiempo periodoTiempo) {
		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime inicio = LocalDateTime.parse(periodoTiempo.getMomentoInicial(), formatter);
			LocalDateTime fin = LocalDateTime.parse(periodoTiempo.getMomentoFinal(), formatter);
			List<ReporteProveedorCount> registros = repository.reporteProveedorPlanID(periodoTiempo.getPlanId(),inicio, fin);
			if (registros == null) {
				return new ReporteProveedor("Reporte no generado", 220);
			}
			Double totalMonto = (double) 0;
			for (ReporteProveedorCount registro : registros) {
				totalMonto = totalMonto + registro.getTotalMonto();
			}
			return new ReporteProveedor("Reporte generado", 210, totalMonto, registros);
		} catch (Exception ex) {

			return new ReporteProveedor("Reporte no generado", 230);
		}
	}

}
