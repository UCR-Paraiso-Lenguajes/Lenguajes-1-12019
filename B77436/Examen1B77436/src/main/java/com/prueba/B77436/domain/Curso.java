package com.prueba.B77436.domain;

import java.util.ArrayList;

public class Curso {
	
	private int idCurso;
	private String nombre;
	private String siglas;
	private int creditos;
	private ArrayList<Integer> requisitos;
	
	public Curso(int idCurso, String nombre, String siglas, int creditos, ArrayList<Integer> requisitos) {
		if(nombre.equals("") || siglas.equals(""))throw new RuntimeException("Algunos campos vienen vacios");
		if(creditos<0 || idCurso<0) throw new RuntimeException("El campo entero viene con datos no validos");
		this.idCurso=idCurso;
		this.nombre=nombre;
		this.siglas=siglas;
		this.creditos=creditos;
		
		for(int i=0;i<requisitos.size();i++) {
			if(requisitos.get(i)==this.idCurso)
				throw new RuntimeException("El requesito no puede ser para si mismo");
		}
		
		this.requisitos=requisitos;
	}
	
	public Curso(int idCurso, String nombre, String siglas, int creditos) {
		if(nombre.equals("") || siglas.equals(""))throw new RuntimeException("Algunos campos vienen vacios");
		if(creditos<0 || idCurso<0) throw new RuntimeException("El campo entero viene con datos no validos");
		this.idCurso=idCurso;
		this.nombre=nombre;
		this.siglas=siglas;
		this.creditos=creditos;
		this.requisitos=requisitos;
	}
	
	

	public int getIdCurso() {
		return idCurso;
	}



	public void setIdCurso(int idCurso) {
		if(idCurso<0)throw new RuntimeException("Dato vacio");
		this.idCurso = idCurso;
	}



	public ArrayList<Integer> getRequisitos() {
		return requisitos;
	}



	public void setRequisitos(ArrayList<Integer> requisitos) {
		
		this.requisitos = requisitos;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre.equals("")) throw new RuntimeException("Dato erroneo");
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		if(siglas.equals("")) throw new RuntimeException("Dato erroneo");
		this.siglas = siglas;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		if(creditos<0) throw new RuntimeException("El campo no es valido");
		this.creditos = creditos;
	}
	
	

}
