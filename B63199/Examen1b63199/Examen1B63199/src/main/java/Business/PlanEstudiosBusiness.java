package Business;

import java.util.ArrayList;
import java.util.List;

import Domain.Curso;
import Domain.PlanEstudios;

public class PlanEstudiosBusiness {

	List<PlanEstudios> planes = new ArrayList<PlanEstudios>();
	
	public void insertarPlanEstudios(PlanEstudios plan) {		
		planes.add(plan);
	}
	
	public void eliminarPlan(PlanEstudios plan) {
		for (int i = 0; i < planes.size() ; i++) {
			if(planes.get(i).getNombre().equals(plan.getNombre())) {
				planes.remove(i);
			}throw new RuntimeException("El plan no se encuentra en el sistema.");
		}
	}
	
	public void editarPlan(PlanEstudios plan) {
		for (int i = 0; i < planes.size(); i++) {
			if(planes.get(i).getNombre().equals(plan.getNombre())) {
				planes.get(i).setNombre(plan.getNombre());
				planes.get(i).setCursosDelPlan(plan.getCursosDelPlan());
			}throw new RuntimeException("El plan no se encuentra en el sistema.");
		}
	}
	
	public PlanEstudios getPlan(PlanEstudios plan) {
		PlanEstudios planBuscado= new PlanEstudios();
		for (int i = 0; i < planes.size() ; i++) {
			if(planes.get(i).getNombre().equals(plan.getNombre()) ) {
				planBuscado = planes.get(i);
			} 
		}
		if(planBuscado != null) {
			return planBuscado;
		} throw new RuntimeException("El plan buscado no existe.");
	}
	
	//Extras
	public int getCantidadCursosTotal(PlanEstudios plan) {
		return getPlan(plan).getCursosDelPlan().size();
		 
	}
	public int getCantidadCreditosTotal(PlanEstudios plan) {
		PlanEstudios planEst = getPlan(plan);
		int creditos=0;
		for (int i = 0; i < planEst.getCursosDelPlan().size(); i++) {
			creditos+=planEst.getCursosDelPlan().get(i).getCreditos();
		}
		return creditos;
	}
	
	
}
