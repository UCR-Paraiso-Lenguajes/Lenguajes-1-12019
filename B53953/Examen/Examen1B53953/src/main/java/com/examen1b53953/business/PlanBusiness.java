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

	public PlanDeEstudio guardarPlan(PlanDeEstudio plan) {
		
		planDeEstudiosData.guardarPlan(plan);
		return plan;
	}

	public void actualizarPlan(PlanDeEstudio plan, PlanDeEstudio planActualizado) {
		 planDeEstudiosData.actualizarPlan(plan, planActualizado);
		
	}

	public void eliminarPlan(int id) {
	 
		planDeEstudiosData.eliminarPlan(id);
		
	}

	public void agregarCurso(Curso curso) {
		planDeEstudiosData.agregarCurso(curso);;
	}
	
	 public int calcularCursosPlan(PlanDeEstudio plan) {
			
			return planDeEstudiosData.calcularCursosPlan(plan);
		
	}
}
