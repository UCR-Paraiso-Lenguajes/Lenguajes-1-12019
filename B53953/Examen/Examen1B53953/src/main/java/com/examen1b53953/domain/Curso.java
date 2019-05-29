package com.examen1b53953.domain;

import java.util.ArrayList;

public class Curso {

	
	private String nombre;
	private String sigla;
	private int creditos;
	private ArrayList<Curso> requisitos;
	
	
	
	public Curso() {
		super();
	}




	public Curso(String nombre, String sigla, int creditos) {
		
		super();
		if(creditos <= 0) throw new RuntimeException("Los creditos deben ser mayor a 0");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(sigla == null || sigla.trim().equals("")) throw new RuntimeException("La sigla es requerida");

		
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getSigla() {
		return sigla;
	}




	public void setSigla(String sigla) {
		this.sigla = sigla;
	}




	public int getCreditos() {
		return creditos;
	}




	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	
	
	
	
}
