package com.exa.ucr.ac.cr.Domain;

public class Carrera {
	
	private String name;
	private PlanEstudios planEstudios;
	
	public Carrera(String name, PlanEstudios planEstudios) {
		
		this.name = name;
		this.planEstudios = planEstudios;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlanEstudios getPlanEstudios() {
		return planEstudios;
	}
	public void setPlanEstudios(PlanEstudios planEstudios) {
		this.planEstudios = planEstudios;
	}

	@Override
	public String toString() {
		return "Carrera [name=" + name + ", planEstudios=" + planEstudios + "]";
	}
	
	
	
}
