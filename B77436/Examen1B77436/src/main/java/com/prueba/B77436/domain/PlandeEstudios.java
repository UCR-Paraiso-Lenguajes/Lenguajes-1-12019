package com.prueba.B77436.domain;

import java.util.ArrayList;

public class PlandeEstudios {
	
	private String nombre;
	private ArrayList<Curso> cursos;
	private ArrayList<Ciclo> ciclos;
	
	public PlandeEstudios(String nombre, ArrayList<Curso> cursos) {
		if(nombre.equals(""))throw new RuntimeException("Dato invalido");
		if(cursos.size()<0)throw new RuntimeException("Dato invalido");
		this.nombre=nombre;
		this.cursos=cursos;
	}
	
	public PlandeEstudios(String nombre, ArrayList<Curso> cursos, ArrayList<Ciclo> ciclos) {
		if(nombre.equals(""))throw new RuntimeException("Dato invalido");
		if(cursos.size()<0)throw new RuntimeException("Dato invalido");
		this.nombre=nombre;
		this.cursos=cursos;
		this.ciclos=ciclos;
	}

	public ArrayList<Ciclo> getCiclos() {
		return ciclos;
	}



	public void setCiclos(ArrayList<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre.equals(""))throw new RuntimeException("Dato invalido");
		this.nombre = nombre;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		if(cursos.size()<0)throw new RuntimeException("Dato invalido");
		this.cursos = cursos;
	}
	
	
	

}
