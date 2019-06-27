package com.exa.ucr.ac.cr.Domain;

import java.util.Iterator;

public class Curso {

	private String nombre; 
	private String siglas; 
	private int creditos;
	private Iterator<Curso> requisitos; 
	private boolean esFinal;
	private boolean isInicial;
	
	
	

	public Curso(String nombre, String siglas, int creditos, Iterator<Curso> requisitos, boolean esFinal,
			boolean isInicial) {
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.requisitos = requisitos;
		this.esFinal = esFinal;
		this.isInicial = isInicial;
	}

	public Curso() {

	}
	
	public boolean isEsFinal() {
		return esFinal;
	}

	public void setEsFinal(boolean esFinal) {
		this.esFinal = esFinal;
	}

	public boolean isInicial() {
		return isInicial;
	}



	public void setInicial(boolean isInicial) {
		this.isInicial = isInicial;
	}



	public String getNombre() {
		return nombre;
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
	public Iterator<Curso> getRequisitos() {
		return requisitos;
	}


	public void setRequisitos(Iterator<Curso> requisitos) {
		this.requisitos = requisitos;
	}


	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", siglas=" + siglas + ", creditos=" + creditos + "]";
	}
	
	
	
}
