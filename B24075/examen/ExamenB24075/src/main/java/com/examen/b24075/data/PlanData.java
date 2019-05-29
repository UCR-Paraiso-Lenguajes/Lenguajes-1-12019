package com.examen.b24075.data;

import java.util.ArrayList;
import java.util.List;

import com.examen.b24075.domain.Curso;
import com.examen.b24075.domain.Datos;
import com.examen.b24075.domain.Plan;

public class PlanData {
	
	public static int cursosPorPlan(String nombrePlan) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos=	Datos.cursosDatos;
		Curso cursoActual= new Curso();
		int cantidad=0;
		for(int indice = 0;indice<cursos.size();indice++)
		{
			cursoActual= cursos.get(indice);
		    if(cursoActual.getPlan().getNombre().equals(nombrePlan)) cantidad++;
		    	
		}

		return cantidad;
		
	}
	
	public static int creditosPorPlan(String nombrePlan) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos=	Datos.cursosDatos;
		Curso cursoActual= new Curso();
		int cantidad=0;
		for(int indice = 0;indice<cursos.size();indice++)
		{
			cursoActual= cursos.get(indice);
		    if(cursoActual.getPlan().getNombre().equals(nombrePlan)) {
		  
		    	cantidad +=cursoActual.getCreditos();
		    }
		    	
		}

		return cantidad;
		
	}
	
	
	
	public static Plan guardarPlan(Plan plan) {

		Datos.planesDatos.add(plan);
		
		
		return(Plan) Datos.planesDatos.get(Datos.planesDatos.size()-1);
	
	}
	
	
	public static void eliminarPlan(Plan plan) {

		Datos.planesDatos.remove(plan);
		
	
	}
	
	
	public static boolean existeCurso(Plan plan) {

		for(int indice = 0;indice<Datos.planesDatos.size();indice++)
		{
			
		    if(Datos.planesDatos.get(indice).equals(plan))
		    	return true;
		    	
		}
		return false;
	
	}
	
	
	public static void actualizarPlan(Plan plan) {

		
		for(int indice = 0;indice<Datos.planesDatos.size();indice++)
		{
			
		    if(Datos.planesDatos.get(indice).getNombre().equals(plan.getNombre()))
		    	
		    	Datos.planesDatos.set(indice,plan); 
		    	   	
		}
	
	}
	
	
	public static Plan buscarCurso(Plan plan) {

		
		for(int indice = 0;indice<Datos.planesDatos.size();indice++)
		{
			
		    if(Datos.planesDatos.get(indice).getNombre().equals(plan.getNombre()))
		    	
		    return Datos.planesDatos.get(indice);
		    	   	
		}
		return plan;
	
	}
	
	
  

}
