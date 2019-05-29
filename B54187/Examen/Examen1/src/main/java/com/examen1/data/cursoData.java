package com.examen1.data;

import java.util.List;

import com.examen1.domain.Curso;
import com.examen1.exceptions.Exceptions;

public class cursoData {
	Curso cursoNuevoCurso;
	Exceptions exceptionMessage = new Exceptions();
	List <Curso> listaCursos = null;
	String mensaje = null;
   
    
	private List<Curso> crearCursoSinRequisitos(Curso curso) {
		
		for (int i = 0; i < listaCursos.size(); i++) {
			if(listaCursos.get(i).equals(curso.getNombre())) {
				mensaje = exceptionMessage.cursoRepetido();
			} else {
				listaCursos.add(curso);
			}
		}
		return listaCursos;
	}
	
	private List<Curso> crearCursoConRequisitos(Curso curso, String requisitos){
		
		for (int i = 0; i < listaCursos.size(); i++) {
			if(listaCursos.get(i).equals(curso.getNombre())) {
				mensaje = exceptionMessage.cursoRepetido();
			} else {
				curso.setRequisitos(requisitos);
				listaCursos.add(curso);
			}
		}
		return listaCursos;

	}
}	
	