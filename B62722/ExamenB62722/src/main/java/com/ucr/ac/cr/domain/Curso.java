package com.ucr.ac.cr.domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String nombre;
	private String siglas;
	private String ciclo;
	private int creditos;
	private List<Curso> cursosRequisito = new ArrayList<Curso>();

	public Curso(String nombre, String siglas, String ciclo, int creditos) {
		if(nombre == null) throw new RuntimeException("El nombre es requerido.");
		if(siglas == null) throw new RuntimeException("Las siglas son requeridas.");
		if(creditos <=  0) throw new RuntimeException("El curso debe  tener 1 o más créditos.");
		this.nombre = nombre;
		this.siglas = siglas;
		this.ciclo = ciclo;
		this.creditos = creditos;
	}
	
	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) throw new RuntimeException("El nombre es requerido.");
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		if(siglas == null) throw new RuntimeException("Las siglas son requeridas.");
		this.siglas = siglas;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		if(creditos <=  0) throw new RuntimeException("El curso debe  tener 1 o más créditos.");
		this.creditos = creditos;
	}

	public List<Curso> getCursosRequisito() {
		return cursosRequisito;
	}

	public void setCursosRequisito(List<Curso> cursosRequisito) {
		this.cursosRequisito = cursosRequisito;
	}
	
}
