package com.examen1b53953.domain;

public class PlanDeEstudio {
	
	private String nombre;
	private Curso curso;
	
	
	public PlanDeEstudio() {
		super();
		
	}


	public PlanDeEstudio(String nombre, Curso curso) {
		super();
		
		
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(curso == null || curso.equals("")) throw new RuntimeException("El curso es requerido");
		
		this.nombre = nombre;
		this.curso = curso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
	

}
