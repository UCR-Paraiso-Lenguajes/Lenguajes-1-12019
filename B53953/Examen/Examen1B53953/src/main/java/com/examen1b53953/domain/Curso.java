package com.examen1b53953.domain;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String nombre;
	private String sigla;
	private int creditos;
	private ArrayList<Curso> requisitos;
	
	
	
	public Curso() {
		super();
	}




	public Curso(int id, String nombre, String sigla, int creditos) {
		
		super();
		if(creditos <= 0) throw new RuntimeException("Los creditos deben ser mayor a 0");
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(sigla == null || sigla.trim().equals("")) throw new RuntimeException("La sigla es requerida");

		this.id = id;
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
	}
	
	




	public Curso(int id, String nombre, String sigla, int creditos, ArrayList<Curso> requisitos) {
		super();
		
		if(creditos <= 0) throw new RuntimeException("Los creditos deben ser mayor a 0");
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(sigla == null || sigla.trim().equals("")) throw new RuntimeException("La sigla es requerida");
		if(requisitos == null || requisitos.equals("")) throw new RuntimeException("El o los requisitos son requeridos");
		
		
		this.id = id;
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
		this.requisitos = requisitos;
	}




	public String getNombre() {
		
		return nombre;
	}




	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre = nombre;
	}




	public String getSigla() {
		return sigla;
	}




	public void setSigla(String sigla) {
		if(sigla == null || sigla.trim().equals("")) throw new RuntimeException("La sigla es requerida");
		this.sigla = sigla;
	}




	public int getCreditos() {
		return creditos;
	}




	public void setCreditos(int creditos) {
		if(creditos <= 0) throw new RuntimeException("Los creditos deben ser mayor a 0");
		this.creditos = creditos;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		if(id <= 0) throw new RuntimeException("El id debe ser mayor a 0");
		this.id = id;
	}




	public ArrayList<Curso> getRequisitos() {
		return requisitos;
	}




	public void setRequisitos(ArrayList<Curso> requisitos) {
		if(requisitos == null || requisitos.equals("")) throw new RuntimeException("El o los requisitos son requeridos");
		this.requisitos = requisitos;
	}




	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", sigla=" + sigla + ", creditos=" + creditos
				+ ", requisitos=" + requisitos + "]";
	}
	
	
	
	
	
}
