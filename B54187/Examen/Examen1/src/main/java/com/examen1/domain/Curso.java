package com.examen1.domain;

public class Curso {
	
	private String nombre;
	private String siglas;
	private int creditos;
	private String requisitos;

	public String getNombre() {
		return nombre;
	}

	public Curso(String nombre, String siglas, int creditos, String requisitos) {
		super();
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.requisitos = requisitos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	


}
