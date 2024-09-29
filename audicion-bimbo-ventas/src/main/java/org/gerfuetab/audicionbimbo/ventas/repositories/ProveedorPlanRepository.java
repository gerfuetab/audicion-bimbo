package org.gerfuetab.audicionbimbo.ventas.repositories;



import java.util.List;

import org.gerfuetab.audicionbimbo.ventas.models.entity.Plan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlan;
import org.gerfuetab.audicionbimbo.ventas.models.entity.ProveedorPlanPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProveedorPlanRepository extends CrudRepository<ProveedorPlan, ProveedorPlanPK> {
	
    @Query("select u.proveedorPlanPK.plan from ProveedorPlan u where  u.proveedorPlanPK.proveedor.proveedor_id=?1")
    List<Plan> PlanXProveedor(Long proveedor_id);
}
