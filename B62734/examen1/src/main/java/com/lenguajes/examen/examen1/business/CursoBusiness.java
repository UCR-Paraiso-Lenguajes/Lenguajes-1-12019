package com.lenguajes.examen.examen1.business;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import com.lenguajes.examen.examen1.domain.Curso;
import com.lenguajes.examen.examen1.domain.CursoConRequisitos;
import com.lenguajes.examen.examen1.domain.CursoInicial;
import com.lenguajes.examen.examen1.excepciones.CursoException;

public class CursoBusiness {
	@Autowired
	private ArrayList<Curso> cursos;
	
	public CursoBusiness() {
		super();
	}
	public void crear(Curso Curso) {
		if (cursos.contains(Curso)) {
			throw new CursoException("el curso ya existe");
		}else {
			cursos.add(Curso);
		}
	}
	public void actualizar(Curso CursoViejo,Curso CursoNuevo) {
		if (!cursos.contains(CursoViejo)) {
			throw new CursoException("el curso no existe");
		}else {
			cursos.set(cursos.indexOf(CursoViejo), CursoNuevo);
		}
	}
	public void delete(String nombre) {
		Curso curso=getCursoPorNombre(nombre);
		if (!cursos.contains(curso)) {
			throw new CursoException("el curso ya existe");
		}else {
			cursos.remove(curso);
		}
	}
	public Curso getCursoPorNombre(String nombre) {
		Curso curso=null;
		for (int cursosCuenta = 0; cursosCuenta < cursos.size(); cursosCuenta++) {
			if (cursos.get(cursosCuenta).getNombre().equals(nombre)) {
				curso=cursos.get(cursosCuenta);
			}
		}
		return curso;
	}
	public ArrayList<Curso> listar() {
		return cursos;
	}
	

}
