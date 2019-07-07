package com.prueba.B77436.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.B77436.controller.PlanEstudiosController;
import com.prueba.B77436.domain.PlandeEstudios;

@Service
public class PlanEstudioBusiness {
	
	@Autowired
	private PlanEstudiosController planEstudio;
	
	public PlandeEstudios updatePlan(String carrera, PlandeEstudios plan) {
		PlandeEstudios planNuevo= planEstudio.cargarEstadoPlandeEstudio();
		planNuevo=plan;
		return planNuevo;
	}
	
	public PlandeEstudios selectPlan(String carrera) {
		PlandeEstudios plandeEstudio= planEstudio.cargarEstadoPlandeEstudio();
		return plandeEstudio;
	}
	
	public void deletePlan(String carrera) {
		PlandeEstudios plandeEstudio= planEstudio.cargarEstadoPlandeEstudio();
		if(planEstudio.cargarEstadoPlandeEstudio().getNombre().equals(carrera))
			planEstudio.cargarEstadoPlandeEstudio().equals("");
	}

}
