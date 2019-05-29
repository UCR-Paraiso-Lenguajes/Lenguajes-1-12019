package com.cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.List;

public class PlanDeEstudio {
	
	private String nombre;
	private ArrayList<Curso> cursos;
	private String carrera;
	
	public PlanDeEstudio(String nombre, ArrayList<Curso> cursos, String carrera) {
		super();
		this.nombre = nombre;
		this.cursos = cursos;
		this.carrera = carrera;
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
	
	public List<Curso> obtenerPrerequisitos(Curso curso, ArrayList<Curso> requisitos)
	{
		if(curso.getRequisitos() != null) {
			for (Curso requisito : curso.getRequisitos()) {
				obtenerPrerequisitos(requisito, requisitos);
			}
		}
		requisitos.add(curso);
		return requisitos;
	}
	
	public int obtenerCantidadTotalDeCreditos() {
		int result = 0;
		for (Curso curso : cursos) {
			result += curso.getCreditos();
		}
		return result;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
}
