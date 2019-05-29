package com.ucr.ac.cr.planDeEstudios.domain;

import java.util.List;

public class Carrera {
	
	private String nombreCarrera;
	private PlanDeEstudios planDeEstudios;
	private List<Curso> cursos;
	
	public Carrera(String nombreCarrera, PlanDeEstudios planDeEstudios, List<Curso> cursos) {
		super();
		this.nombreCarrera = nombreCarrera;
		this.planDeEstudios = planDeEstudios;
		this.cursos = cursos;
	}


	public String getNombreCarrera() {
		return nombreCarrera;
	}


	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}


	public PlanDeEstudios getPlanDeEstudios() {
		return planDeEstudios;
	}


	public void setPlanDeEstudios(PlanDeEstudios planDeEstudios) {
		this.planDeEstudios = planDeEstudios;
	}


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	

}
