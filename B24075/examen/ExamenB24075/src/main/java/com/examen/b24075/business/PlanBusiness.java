package com.examen.b24075.business;

import com.examen.b24075.data.PlanData;
import com.examen.b24075.domain.Plan;

public class PlanBusiness {

	
	public static int cursosPorPlan(String nombrePlan) {
		
	return PlanData.cursosPorPlan(nombrePlan);
		
	}
	
	public static int creditosPorPlan(String nombrePlan) {
		
		return PlanData.creditosPorPlan(nombrePlan);
		
	}
	
	
	
	public static Plan guardarPlan(Plan plan) {

		return PlanData.guardarPlan(plan);
	
	}
	
	
	public static void eliminarPlan(Plan plan) {

		PlanData.eliminarPlan(plan);
		
	
	}
	
	
	public static boolean existeCurso(Plan plan) {

		return PlanData.existeCurso(plan);
	
	}
	
	
	public static void actualizarPlan(Plan plan) {

		PlanData.actualizarPlan(plan);
	
	}
	
	
	public static Plan buscarCurso(Plan plan) {

		return PlanData.buscarCurso(plan);
	
	}
	
	
  
	
}
