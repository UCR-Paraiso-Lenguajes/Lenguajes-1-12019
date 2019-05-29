package com.lenguajes.examen.examen1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.lenguajes.examen.examen1.excepciones.RequisitoException;

public class CursoConRequisitos extends Curso{
	
	private List<Curso> requisitos;

	public CursoConRequisitos(String nombre, String siglas, int creditos) {
		super(nombre, siglas, creditos);
		requisitos=new ArrayList<Curso>();
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
