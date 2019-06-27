package com.examen_1.b67156.domain;

import java.util.ArrayList;

public class Curso {

	private String nombre;
	private String siglas;
	private int creditos;
	private int ciclo;
	
	public Curso(String nombre, String siglas, int creditos, int ciclo) {
		
		if(nombre.equals(""))throw new RuntimeException("nombre cursos vacio");
		if(siglas.equals(""))throw new RuntimeException("siglas vacio");
		if(creditos == 0)throw new RuntimeException("creditos vacio");
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
		this.ciclo = ciclo;
	}
	
	

	public int getCiclo() {
		return ciclo;
	}



	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
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



	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", siglas=" + siglas + ", creditos=" + creditos + ", ciclo=" + ciclo + "]";
	}

}
