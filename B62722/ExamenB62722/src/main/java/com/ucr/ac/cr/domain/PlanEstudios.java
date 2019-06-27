package com.ucr.ac.cr.domain;

import java.util.ArrayList;
import java.util.List;

public class PlanEstudios {
	
	private int totalCursos;
	private int totalCreditos;
	private List<Curso> listaCursos;

	public PlanEstudios() {
		listaCursos = new ArrayList<Curso>();
	}

	public int getTotalCursos() {
		return totalCursos;
	}

	public void setTotalCursos(int totalCursos) {
		if(totalCursos <=  0) throw new RuntimeException("El plan de estudios debe tener cursos.");
		this.totalCursos = totalCursos;
	}

	public int getTotalCreditos() {
		return totalCreditos;
	}

	public void setTotalCreditos(int totalCreditos) {
		if(totalCreditos <=  0) throw new RuntimeException("El curso debe  tener 1 o más créditos.");
		this.totalCreditos = totalCreditos;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}
	
}
