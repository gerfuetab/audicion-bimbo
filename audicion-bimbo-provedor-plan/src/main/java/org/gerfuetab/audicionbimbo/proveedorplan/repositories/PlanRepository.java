package org.gerfuetab.audicionbimbo.proveedorplan.repositories;

import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Plan;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository extends CrudRepository<Plan, Long> {
}
