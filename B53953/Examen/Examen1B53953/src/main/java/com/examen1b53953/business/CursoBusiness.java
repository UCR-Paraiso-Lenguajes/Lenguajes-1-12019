package com.examen1b53953.business;

import java.util.List;

import com.examen1b53953.data.CursoData;
import com.examen1b53953.domain.Curso;

public class CursoBusiness {
	
    private CursoData cursoData;

	public List<Curso> listarCursos() {
		
		return cursoData.listarCursos();
	}

	public void guardarCurso(Curso curso) {
		
		
		cursoData.guardarCurso(curso);
	}

	public void ActualizarCurso(Curso curso, Curso cursoActualizado) {
	
		cursoData.actualizarCurso(curso, cursoActualizado);
	}

	public void eliminarCurso(int id) {
	    
		cursoData.eliminarCurso(id);
		
	}

	
	
}
