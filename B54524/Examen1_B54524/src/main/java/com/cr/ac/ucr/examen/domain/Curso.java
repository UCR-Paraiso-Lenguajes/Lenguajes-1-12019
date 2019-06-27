package com.cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private int id;
	private String nombre;
	private String sigla;
	private ArrayList<Curso> requisitos;
	private int creditos;
	private String tipoDeCurso;
	private String ciclo;

	
	public Curso(int id, String nombre, String sigla, int creditos, String tipoDeCurso, String ciclo) {
		super();
		if(id < 0) throw new RuntimeException("id inválido");
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre no es válido");
		if(sigla == null || sigla.trim().equals("")) throw new RuntimeException("La sigla no es válido");
		if(tipoDeCurso == null || tipoDeCurso.trim().equals("")) throw new RuntimeException("El tipo de curso no es válido");
		if(creditos < 0) throw new RuntimeException("Cantidad de creditos inválida");
		if(ciclo == null || ciclo.trim().equals("")) throw new RuntimeException("El ciclo del curso no es válido");
		this.id = id;
		this.nombre = nombre;
		this.sigla = sigla;
		this.creditos = creditos;
		this.tipoDeCurso = tipoDeCurso;
	}
	
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
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
	public ArrayList<Curso> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(ArrayList<Curso> requisitos) {
		this.requisitos = requisitos;
	}
	public void agregarRequisito(Curso curso) {
		if(curso.getTipoDeCurso().equals("Final")) throw new RuntimeException("El curso no puede ser requisito de otro curso");
		if(tipoDeCurso.equals("Inicial")) throw new RuntimeException("El curso no puede tener requisitos");
		requisitos.add(curso);
	}
	public String getTipoDeCurso() {
		return tipoDeCurso;
	}
	public void setTipoDeCurso(String tipoDeCurso) {
		this.tipoDeCurso = tipoDeCurso;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Curso> obtenerPrerequisitos()
	{
		return obtenerRequisitos(new ArrayList<Curso>(), this);
	}
	
	private List<Curso> obtenerRequisitos(ArrayList<Curso> cursos, Curso curso) {
		if(curso.getRequisitos() == null) {
			cursos.add(curso);
		}else {
			for (Curso cursoReq : cursos) {
				cursos.add(cursoReq);
				obtenerRequisitos(cursos, cursoReq);
			}
		}
		return cursos;
	}
}
