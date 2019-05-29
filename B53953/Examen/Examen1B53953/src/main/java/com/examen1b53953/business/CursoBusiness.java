package com.examen1b53953.business;

import java.util.ArrayList;
import java.util.List;

import com.examen1b53953.data.CursoData;
import com.examen1b53953.domain.Curso;

public class CursoBusiness {
	
    private CursoData cursoData;

	public List<Curso> listarCursos() {
		
		return cursoData.listarCursos();
	}

	public Curso guardarCurso(Curso curso) {
		
		
		cursoData.guardarCurso(curso);
		return curso;
	}

	public void ActualizarCurso(Curso curso, Curso cursoActualizado) {
	
		cursoData.actualizarCurso(curso, cursoActualizado);
	}

	public void eliminarCurso(int id) {
	    
		cursoData.eliminarCurso(id);
		
	}

	
	 public Curso agregarRequisitoAlCurso(Curso curso, ArrayList<Curso> cursosR) {
		return cursoData.agregarRequisitoAlCurso(curso, cursosR);
		
	 }
}
