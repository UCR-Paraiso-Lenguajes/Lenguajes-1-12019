package com.lenguajes.examen.examen1.domain;

import java.util.ArrayList;
import java.util.List;

import com.lenguajes.examen.examen1.excepciones.RequisitoException;

public class CursoFinal extends Curso {
	private List<Curso> requisitos;

	public CursoFinal(String nombre, String siglas, int creditos) {
		super(nombre, siglas, creditos);
		requisitos=new ArrayList<Curso>();

		// TODO Auto-generated constructor stub
	}

	public List<Curso> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(List<Curso> requisitos) {
		this.requisitos = requisitos;
	}
	public  void agregarRequisito(Curso curso) {
		if (curso instanceof CursoFinal) {
			throw new RequisitoException("Un curso Final no puede ser requisito");
		}else  {
			if (getNombre().equals(curso.getNombre()) && getCreditos()==curso.getCreditos()) {
				throw new RequisitoException("Un curso no puede ser requisito de si mismo");
			}else {
				requisitos.add(curso);	
			}
		}
	}


}
