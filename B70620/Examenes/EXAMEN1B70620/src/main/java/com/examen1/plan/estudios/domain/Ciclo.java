package com.examen1.plan.estudios.domain;

import java.util.ArrayList;

public class Ciclo {

	private int id;
	private ArrayList<Curso> cursos;

	protected Ciclo(int id) {
		this.id = id;
		cursos = new ArrayList<Curso>();
	}

	public void agregarRequisitoCurso(String siglaCursoAgregar, String siglaCursoRequisito) {
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getSiglas().equals(siglaCursoAgregar)) {
				cursos.get(i).agregarCurso(siglaCursoRequisito);
				return;
			}
		}
		throw new RuntimeException("El ciclo no contiene ese curso");
	}

	public void agregarCurso(Curso nuevoCurso) {
		if(existeCursoEnCiclo(nuevoCurso.getSiglas()))
			throw new RuntimeException("El curso ya existe en el ciclo");

		cursos.add(nuevoCurso);
	}

	public int getId() {
		return this.id;
	}

	public boolean existeCursoEnCiclo(String siglaCurso) {
		for (int i = 0; i < cursos.size(); i++)
			if (cursos.get(i).getSiglas().equals(siglaCurso))
				return true;
		return false;
	}
	
	protected int obtenerTotalCreditosDelCiclo() {
		int total = 0;
		for (int i = 0; i < cursos.size(); i++)
			total += cursos.get(i).getCreditos();
		return total;
	}

	public int obtenerTotalCursosDelCiclo() {
		return cursos.size();
	}
}
