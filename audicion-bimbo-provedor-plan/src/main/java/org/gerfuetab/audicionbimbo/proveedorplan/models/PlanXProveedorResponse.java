package org.gerfuetab.audicionbimbo.proveedorplan.models;



import java.util.List;

import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Plan;

public class PlanXProveedorResponse {

    private int codigo;
    private String mensaje;   
    private List<Plan> planes;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<Plan> getPlanes() {
		return planes;
	}
	public void setPlanes(List<Plan> planes) {
		this.planes = planes;
	}
	public PlanXProveedorResponse(int codigo, String mensaje, List<Plan> planes) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.planes = planes;
	}


}
