package Business;

import java.util.ArrayList;
import java.util.List;

import Domain.Curso;
import Domain.PlanEstudios;

public class PlanEstudiosBusiness {

	List<PlanEstudios> planes = new ArrayList<PlanEstudios>();
	
	public void insertarPlanEstudios(PlanEstudios plan) {
		PlanEstudios planNuevo = new PlanEstudios();
		
		planNuevo.setNombre(plan.getNombre());
		planNuevo.setCursosDelPlan(plan.getCursosDelPlan());
		
		planes.add(planNuevo);
	}
	
	public int getCantidadCreditosTotal(PlanEstudios plan) {
		return getCursosTotal(plan).size();
	}
	
	public List<Curso> getCursosTotal(PlanEstudios plan) {
		List<Curso> cursosPlan= new ArrayList<Curso>();
		
		cursosPlan = getPlan(plan).getCursosDelPlan();
		
		return cursosPlan;
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
	
	public int getCantidadCursosTotal(List<Curso> cursos) {
		int cantidad=0;
		
		
		return cantidad;
	}
	
	public List<Curso> cursosRequeridos(Curso curso){
		List<Curso> cursosRequeridos = new ArrayList<Curso>();
		cursosRequeridos = curso.getCursosRequisito();
		
		return cursosRequeridos;
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
	
}
