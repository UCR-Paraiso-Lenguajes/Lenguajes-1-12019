package com.examen1b53953.business;

import java.util.List;

import com.examen1b53953.data.CursoData;
import com.examen1b53953.domain.Curso;

public class CursoBusiness {
	
    private CursoData cursoData;

	public List<Curso> listarCursos() {
		
		return cursoData.listarCursos();
	}

	public Curso guardar(Curso curso) {
		
		
		return cursoData.guardarCurso(curso);
	}

	public void editar(String sigla, Curso curso) {
	
		cursoData.actualizarCurso();
	}

	public void eliminar(int id) {
	    
		cursoData.eliminarCurso(id);
		
	}

	
	
}
