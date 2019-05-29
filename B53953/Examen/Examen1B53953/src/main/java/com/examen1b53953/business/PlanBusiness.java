package com.examen1b53953.business;

import java.util.List;

import com.examen1b53953.data.PlanDeEstudioData;
import com.examen1b53953.domain.Curso;
import com.examen1b53953.domain.PlanDeEstudio;

public class PlanBusiness {
	
	private PlanDeEstudioData planDeEstudiosData;

	public List<PlanDeEstudio> listarPlanes() {
		
		return planDeEstudiosData.listarPlanes();
	}

	public void guardarPlan(PlanDeEstudio plan) {
		
		planDeEstudiosData.guardarPlan(plan);
	}

	public void ActualizarPlan(PlanDeEstudio plan, PlanDeEstudio planActualizado) {
		 planDeEstudiosData.actualizarPlan(plan, planActualizado);
		
	}

	public void eliminarPlan(int id) {
	 
		planDeEstudiosData.eliminarPlan(id);
		
	}

}
