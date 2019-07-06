package com.examen.b24075.data;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.examen.b24075.domain.Curso;
import com.examen.b24075.domain.Datos;


public class CursoData {
		
	
	
	//metodo recursivo obtiene todos los requisitos hasta el final
	public static List<Curso> obtenerRequisitosCurso(Curso curso ){
		List<Curso> totalRequisitos = curso.getRequisitos();
		if(totalRequisitos.size()==0) {

				 return totalRequisitos;
			
	}else  totalRequisitos.addAll(obtenerRequisitosCurso(curso));
		return totalRequisitos;
		
}
	
	
	public static Curso guardarCurso(Curso curso) {

		Datos.cursosDatos.add(curso);
		
		
		return(Curso) Datos.cursosDatos.get(Datos.cursosDatos.size()-1);
	
	}
	
	
	public static void eliminarCurso(Curso curso) {

		Datos.cursosDatos.remove(curso);
		
	
	}
	
	
	public static boolean existeCurso(Curso curso) {

		for(int indice = 0;indice<Datos.cursosDatos.size();indice++)
		{
			
		    if(Datos.cursosDatos.get(indice).equals(curso))
		    	return true;
		    	
		}
		return false;
	
	}
	
	
	public static void actualizarCurso(Curso curso) {

		
		for(int indice = 0;indice<Datos.cursosDatos.size();indice++)
		{
			
		    if(Datos.cursosDatos.get(indice).getSigla().equals(curso.getSigla()))
		    	
		    	Datos.cursosDatos.set(indice,curso); 
		    	   	
		}
	
	}
	
	
	public static Curso buscarCurso(Curso curso) {

		
		for(int indice = 0;indice<Datos.cursosDatos.size();indice++)
		{
			
		    if(Datos.cursosDatos.get(indice).getSigla().equals(curso.getSigla()))
		    	
		    return Datos.cursosDatos.get(indice);
		    	   	
		}
		return curso;
	
	}
	
	
}


