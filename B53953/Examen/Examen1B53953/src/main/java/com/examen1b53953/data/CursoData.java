package com.examen1b53953.data;

import java.util.ArrayList;
import java.util.List;

import com.examen1b53953.domain.Curso;

public class CursoData {

	
	private ArrayList<Curso> cursos;
	
	public List<Curso> listarCursos() {
		
		return cursos;
	}

	public Curso guardarCurso(Curso curso) {
		
		cursos.add(curso);
		return curso;
	}

	public void actualizarCurso() {
		
		
	}

	public void eliminarCurso(int id) {
		cursos.remove(id);
		
	}



}
