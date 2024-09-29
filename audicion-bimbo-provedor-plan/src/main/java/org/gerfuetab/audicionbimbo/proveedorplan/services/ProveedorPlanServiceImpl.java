package org.gerfuetab.audicionbimbo.proveedorplan.services;

import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Plan;
import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.Proveedor;
import org.gerfuetab.audicionbimbo.proveedorplan.models.entity.ProveedorPlan;

import org.gerfuetab.audicionbimbo.proveedorplan.repositories.PlanRepository;
import org.gerfuetab.audicionbimbo.proveedorplan.repositories.ProveedorPlanRepository;
import org.gerfuetab.audicionbimbo.proveedorplan.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorPlanServiceImpl implements ProveedorPlanService{

    @Autowired
    private ProveedorRepository repository;
    
    @Autowired
    private PlanRepository repositoryPlan;

    @Autowired
    private ProveedorPlanRepository repositoryProveedorPlan;


    /*@Autowired
    private UsuarioClientRest client;*/

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> listar() {
        return (List<Proveedor>) repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Plan> listarPlan() {
        return (List<Plan>) repositoryPlan.findAll();
    }
   
    
    @Override
    @Transactional(readOnly = true)
    public List<ProveedorPlan> listarProveedorPlan() {
        return (List<ProveedorPlan>) repositoryProveedorPlan.findAll();
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Plan> planXProveedor(Long proveedor_id) {
        return (List<Plan>) repositoryProveedorPlan.PlanXProveedor(proveedor_id);
    }
}
