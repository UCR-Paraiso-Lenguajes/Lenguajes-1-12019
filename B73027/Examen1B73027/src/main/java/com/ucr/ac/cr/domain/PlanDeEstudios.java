package com.ucr.ac.cr.domain;

import java.util.ArrayList;

public class PlanDeEstudios {
	
	private String nombrePlan;
	private ArrayList<Curso> cursosPlan = new ArrayList<Curso>() ;
	
	
	public PlanDeEstudios(String nombrePlan, ArrayList<Curso> cursosPlan) {
		
		this.nombrePlan = nombrePlan;
		this.cursosPlan = cursosPlan;
	}
	public String getNombrePlan() {
		return nombrePlan;
	}
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	public ArrayList<Curso> getCursosPlan() {
		return cursosPlan;
	}
	public void setCursosPlan(ArrayList<Curso> cursosPlan) {
		this.cursosPlan = cursosPlan;
	}
	
}

