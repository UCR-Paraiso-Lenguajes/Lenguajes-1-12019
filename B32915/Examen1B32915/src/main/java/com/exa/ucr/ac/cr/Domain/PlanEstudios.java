package com.exa.ucr.ac.cr.Domain;

import java.util.Iterator;

public class PlanEstudios {
	
	private String name;
	private Iterator<Curso> cursos;
	
	public PlanEstudios() {
	}
	
	public PlanEstudios(String name, Iterator<Curso> cursos) {
		this.name = name;
		this.cursos = cursos;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Iterator<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Iterator<Curso> cursos) {
		this.cursos = cursos;
	}
	
	@Override
	public String toString() {
		return "PlanEstudios [name=" + name + ", cursos=" + cursos + "]";
	}	

}
