package com.cr.ac.ucr.examen.domain;

public class Carrera {

	private int id;
	private String nombre;
	private PlanDeEstudio planDeEstudio;
	
	public Carrera(int id, String nombre) {
		super();
		if(id < 0) throw new RuntimeException("id inválido");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre no es válido");
		this.id = id;
		this.nombre = nombre;
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
