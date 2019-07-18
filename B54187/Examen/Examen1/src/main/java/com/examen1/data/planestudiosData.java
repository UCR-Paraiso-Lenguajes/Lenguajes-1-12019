package com.examen1.data;

import java.util.List;

import com.examen1.domain.Curso;
import com.examen1.domain.PlanEstudios;
import com.examen1.exceptions.Exceptions;

public class planestudiosData {
	
	PlanEstudios planEstudiosNuevo;
	
	List<PlanEstudios> listaPlanEstudios = null;
	
	String mensaje = null;
	
	Exceptions exceptionMessage = new Exceptions();
	
	private List<PlanEstudios> crearPlanEstudios(PlanEstudios planEstudios) {
		
		for (int index = 0; index < listaPlanEstudios.size(); index++) {
			if(listaPlanEstudios.get(index).equals(planEstudios.getNombre())) {
				mensaje = exceptionMessage.planEstudiosRepetido();
			} else {
				listaPlanEstudios.add(planEstudios);
				mensaje = exceptionMessage.planEstudiosInsertado();

			}
		}
		return listaPlanEstudios;
	}
	
	private PlanEstudios agregarCurso(Curso curso) {
		
		for (int index = 0; index < listaPlanEstudios.size(); index++) {
			if(listaPlanEstudios.get(index).equals(curso.getNombre())) {
				mensaje = exceptionMessage.cursoRepetido();
			} else {
				planEstudiosNuevo.setCursos(curso);
				mensaje = exceptionMessage.cursoInsertado();
				return planEstudiosNuevo;
			}
		}
		return planEstudiosNuevo;
	}

}
