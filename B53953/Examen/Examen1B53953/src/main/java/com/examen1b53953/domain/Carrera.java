package com.examen1b53953.domain;

public class Carrera {

	
	private int id;
	private String nombre;
	private PlanDeEstudio planDeEstudio;
	
	
	public Carrera() {
		super();
	
	}


	public Carrera(int id, String nombre, PlanDeEstudio planDeEstudio) {
		
		super();
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(planDeEstudio == null || planDeEstudio.equals("")) throw new RuntimeException("Se requere el plan de estudio");
		
		
		this.id = id;
		this.nombre = nombre;
		this.planDeEstudio = planDeEstudio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public PlanDeEstudio getPlanDeEstudio() {
		return planDeEstudio;
	}


	public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
		this.planDeEstudio = planDeEstudio;
	}
	
	
	
	
	
}
