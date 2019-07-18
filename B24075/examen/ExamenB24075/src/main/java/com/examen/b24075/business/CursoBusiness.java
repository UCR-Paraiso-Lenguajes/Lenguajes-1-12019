package com.examen.b24075.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.examen.b24075.data.CursoData;
import com.examen.b24075.domain.Curso;

public class CursoBusiness {

	@Autowired
	static CursoData cd;
	

	//metodo recursivo obtiene todos los requisitos hasta el final
	public static List<Curso> obtenerRequisitosCurso(Curso curso ){

				 return CursoData.obtenerRequisitosCurso(curso);

		
}
	
	
	public static Curso guardarCurso(Curso curso) {

		
		return CursoData.guardarCurso(curso);
	
	}
	
	
	public static void eliminarCurso(Curso curso) {

		CursoData.eliminarCurso(curso);
	
	
	}
	
	
	public static boolean existeCurso(Curso curso) {

	return CursoData.existeCurso(curso);
	
	}
	
	
	public static void actualizarCurso(Curso curso) {

		CursoData.actualizarCurso(curso);
	}
	
	
	public static Curso buscarCurso(Curso curso) {
		
		return CursoData.buscarCurso(curso);
	
	}
	
	
	
}
