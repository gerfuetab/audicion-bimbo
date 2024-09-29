package org.gerfuetab.audicionbimbo.proveedorplan.services;


import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Plan;
import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Proveedor;
import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.ProveedorPlan;

import java.util.List;

public interface ProveedorPlanService {
    List<Proveedor> listar();
    List<Plan> listarPlan();
    List<ProveedorPlan> listarProveedorPlan();
    List<Plan> planXProveedor(Long proveedor_id);
    
}
