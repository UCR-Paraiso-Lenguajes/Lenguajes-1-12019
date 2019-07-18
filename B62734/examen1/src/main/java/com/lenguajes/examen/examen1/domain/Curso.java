package com.lenguajes.examen.examen1.domain;

import com.lenguajes.examen.examen1.excepciones.CursoException;

public class Curso {
	private static int cont=0;
	private int id;
	private String nombre;
	private String siglas;
	private int creditos;

	public Curso( String nombre, String siglas, int creditos) {
		super();
		cont=cont+1;
		
		this.id = cont;
		if (nombre==null || siglas==null || creditos==0) {
			throw new CursoException("el curso esta vacio");
		}
		this.nombre = nombre;
		this.siglas = siglas;
		this.creditos = creditos;
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
	
}
