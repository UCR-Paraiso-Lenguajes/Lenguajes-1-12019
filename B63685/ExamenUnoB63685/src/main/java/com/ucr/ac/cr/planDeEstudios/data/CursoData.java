package com.ucr.ac.cr.planDeEstudios.data;

import java.util.ArrayList;
import java.util.List;

import com.ucr.ac.cr.planDeEstudios.domain.Curso;

public class CursoData {

	List<Curso> cursos;

	public CursoData() {
		cursos = new ArrayList<Curso>();
	}

	public boolean insertarCurso(Curso curso) {

		boolean cursoInsertado = false;

		if (!cursos.contains(curso)) {
			cursos.add(curso);
			cursoInsertado = true;
		}

		return cursoInsertado;

	}
	//faltan validaciones o excepciones
	public void editarCurso(Curso curso) {
			
		for (Curso cursoActual : cursos) {
			
			if(cursoActual.getIdCurso()==curso.getIdCurso()) {
				
				cursoActual=curso;
				
			}
		}
				
	}
	
	public void delete(int idCurso) {
		
		
		for (int i = 0; i < cursos.size(); i++) {
			
			if(cursos.get(i).getIdCurso()==idCurso) {
				
				cursos.remove(i);
			}
		}
					
		}
	
	
	
	}


