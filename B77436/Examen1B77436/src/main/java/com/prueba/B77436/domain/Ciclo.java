package com.prueba.B77436.domain;

import java.util.ArrayList;

public class Ciclo {
	
	private String ciclo;
	private ArrayList<Curso> cursos;
	private String carrera;
	
	public Ciclo(String ciclo, ArrayList<Curso> cursos, String carrera) {
		if(ciclo.equals("") || carrera.equals(""))throw new RuntimeException("Dato incorrecto");
		
		
		this.ciclo=ciclo;
		this.cursos=cursos;
		this.carrera=carrera;
		
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		if(ciclo.equals(""))throw new RuntimeException("Dato incorrecto");
		this.ciclo = ciclo;
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		if(carrera.equals(""))throw new RuntimeException("Dato incorrecto");
		this.carrera = carrera;
	}
	
	

}
