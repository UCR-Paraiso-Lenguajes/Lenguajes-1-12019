package com.ucr.ac.cr.Examen1.domain;

import java.util.ArrayList;

public class PlandeEstudios {
	
	private static String nombrePlan = "Innovacion";
	private ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	public PlandeEstudios(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}	
	
}
