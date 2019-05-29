package com.cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Curso {
	
	private String nombre;
	private String sigla;
	private ArrayList<Curso> requisitos;
	private List<Curso> cursosQueAbre;
	private int creditos;
	private String tipoDeCurso;

	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public Curso(String nombre, String sigla, int creditos, String tipoDeCurso) {
		super();
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre no es válido");
		if(sigla == null || sigla.trim().equals("")) throw new RuntimeException("La sigla no es válido");
		if(tipoDeCurso == null || tipoDeCurso.trim().equals("")) throw new RuntimeException("El tipo de curso no es válido");
		if(creditos < 0) throw new RuntimeException("Cantidad de creditos inválida");
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
		this.tipoDeCurso = tipoDeCurso;
		
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
	public ArrayList<Curso> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(ArrayList<Curso> requisitos) {
		this.requisitos = requisitos;
	}
	public List<Curso> getCursosQueAbre() {
		return cursosQueAbre;
	}
	public void setCursosQueAbre(List<Curso> cursosQueAbre) {
		this.cursosQueAbre = cursosQueAbre;
	}
	public void agregarRequisito(Curso curso) {
		if(tipoDeCurso.equals("Final")) throw new RuntimeException("El curso no puede tener requisitos");
		requisitos.add(curso);
	}
	public String getTipoDeCurso() {
		return tipoDeCurso;
	}
	public void setTipoDeCurso(String tipoDeCurso) {
		this.tipoDeCurso = tipoDeCurso;
	}
}
