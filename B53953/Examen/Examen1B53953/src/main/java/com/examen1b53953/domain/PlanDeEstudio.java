package com.examen1b53953.domain;

import java.util.ArrayList;

public class PlanDeEstudio {
	
	private int id;
	private String nombre;
	private ArrayList<Curso> cursos;
	
	
	public PlanDeEstudio() {
		super();
		
	}



	public PlanDeEstudio(int id, String nombre, ArrayList<Curso> cursos) {
		super();
		
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(cursos == null || cursos.equals("")) throw new RuntimeException("Los cursos son requeridos");
		
		this.id = id;
		this.nombre = nombre;
		this.cursos = cursos;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre = nombre;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0");
		this.id = id;
	}



	public ArrayList<Curso> getCursos() {
		return cursos;
	}



	public void setCursos(ArrayList<Curso> cursos) {
		if(cursos == null || cursos.equals("")) throw new RuntimeException("Los cursos son requeridos");
		this.cursos = cursos;
	}


	
	
	
	
	

}
