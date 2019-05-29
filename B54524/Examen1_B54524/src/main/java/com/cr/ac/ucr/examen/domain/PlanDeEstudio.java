package com.cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.List;

public class PlanDeEstudio {
	
	private int id;
	private String nombre;
	private ArrayList<Curso> cursos;
	
	public PlanDeEstudio(int id, String nombre) {
		super();
		if(id < 0) throw new RuntimeException("id inválido");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre no es válido");
		this.id = id;
		this.nombre = nombre;
		cursos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public int obtenerCantidadTotalDeCreditos() {
		int result = 0;
		for (Curso curso : cursos) {
			result += curso.getCreditos();
		}
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}

	public void modificarCurso(int id, Curso curso) {
		for (Curso cursoGuardado : cursos) {
			if(cursoGuardado.getId() == id) {
				cursoGuardado = curso;
			}
		}
	}
	
	public void eliminarCurso(int id) {
		for (Curso cursoGuardado : cursos) {
			if(cursoGuardado.getId() == id) {
				cursos.remove(cursoGuardado);
			}
		}
	}
}
