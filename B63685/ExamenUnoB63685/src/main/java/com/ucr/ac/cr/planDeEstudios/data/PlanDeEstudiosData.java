package com.ucr.ac.cr.planDeEstudios.data;

import java.util.ArrayList;
import java.util.List;

import com.ucr.ac.cr.planDeEstudios.domain.Curso;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

public class PlanDeEstudiosData {

	private List<Curso> cursosRequisitos;
	private List<PlanDeEstudios> planesDeEstudio;
	
	public PlanDeEstudiosData() {
		planesDeEstudio = new ArrayList<PlanDeEstudios>();
		cursosRequisitos = new ArrayList<Curso>();
	}

	
	
	
	public List<Curso> calculaPrerequisitos(Curso curso) {

		// mientrasCurso no sea inicial ni final que lo siga agregando
		while (!curso.isFinalOrInicial()) {

			cursosRequisitos.add(curso.getRequisito());

			// luego cambio al curso anterior, osea a su requisito y así sucesivamente
			// hasta que sea un curso inicial o final
			curso = curso.getRequisito();

		}

		// luego se retorna la lista de requisitos
		return cursosRequisitos;

	}
	
	
	public boolean insertarPlanEstudio(PlanDeEstudios planDeEstudio) {

		boolean planInsertado = false;

		if (!planesDeEstudio.contains(planDeEstudio)) {
			planesDeEstudio.add(planDeEstudio);
			planInsertado = true;
		}

		return planInsertado;

	}

	
	
	//faltan validaciones o excepciones
		public void editarPlan(PlanDeEstudios planDeEstudios) {
				
			for (PlanDeEstudios planActual : planesDeEstudio) {
				
				if(planActual.getIdPlan()==planDeEstudios.getIdPlan()) {
					
					planActual=planDeEstudios;
					
				}
			}
				
		}
		
		public void delete(int idPlan) {
			
			
			for (int i = 0; i < planesDeEstudio.size(); i++) {
				
				if(planesDeEstudio.get(i).getIdPlan()==idPlan) {
					
					planesDeEstudio.remove(i);
				}
			}
						
			}
		
}
