package com.examen1b53953.data;

import java.util.ArrayList;
import java.util.List;

import com.examen1b53953.domain.Curso;
import com.examen1b53953.domain.PlanDeEstudio;

public class PlanDeEstudioData {
	
	private PlanDeEstudio plan;
private ArrayList<PlanDeEstudio> planesDeEstudio;
	
	public List<PlanDeEstudio> listarPlanes() {
		
		return planesDeEstudio;
	}

	public void guardarPlan(PlanDeEstudio plan) {
		
		if (!existePlan(plan)) {
			planesDeEstudio.add(plan);
        }
		
	}
	
	public void agregarCurso(Curso curso) {
		plan.getCursos().add(curso);
	}

	
	public boolean existePlan(PlanDeEstudio plan) {
        boolean existe = false;
        for (int i = 0; i < planesDeEstudio.size(); i++) {
            PlanDeEstudio planTemp = planesDeEstudio.get(i);
            if (planTemp.getId() == (plan.getId())) {
                existe = true;
            }

        }
        return existe;
    }
	
	 public void actualizarPlan(PlanDeEstudio plan, PlanDeEstudio planActualizado){
	        for (int i = 0; i < planesDeEstudio.size(); i++) {
	            PlanDeEstudio temp = planesDeEstudio.get(i);
	           
	            if(temp.getId() == plan.getId()){
	                planesDeEstudio.set(i, planActualizado);
	               
	            }
	        }
	    }
	

	 public void eliminarPlan(int id) {
	       
	        for (int i = 0; i < planesDeEstudio.size(); i++) {
	            PlanDeEstudio planTemp = planesDeEstudio.get(i);
	            if(planTemp.getId()==id){
	                planesDeEstudio.remove(i);
	            }
	        }
	 }
	 
	 public int calcularCursosPlan(PlanDeEstudio plan) {
			
				return plan.getCursos().size();
			
		}

}
