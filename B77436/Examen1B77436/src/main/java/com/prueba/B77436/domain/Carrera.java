package com.prueba.B77436.domain;

public class Carrera {
	
	private int idCarrera;
	private String nombre;
	private PlandeEstudios planEstudio;
	
	public Carrera(int idCarrera, String nombre, PlandeEstudios planEstudio) {
		if(idCarrera<0)throw new RuntimeException("Dato invalido");
		if(nombre.equals("") || planEstudio.equals(""))throw new RuntimeException("Dato vacio");
		this.idCarrera=idCarrera;
		this.nombre=nombre;
		this.planEstudio=planEstudio;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		if(idCarrera<0)throw new RuntimeException("Dato invalido");
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre.equals(""))throw new RuntimeException("Dato vacio");
		this.nombre = nombre;
	}

	public PlandeEstudios getPlanEstudio() {
		return planEstudio;
	}

	public void setPlanEstudio(PlandeEstudios planEstudio) {
		if(planEstudio.equals(""))throw new RuntimeException("Dato vacio");
		this.planEstudio = planEstudio;
	}
	
	

}
