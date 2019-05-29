package com.ucr.ac.cr.planDeEstudios.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucr.ac.cr.planDeEstudios.data.PlanDeEstudiosData;
import com.ucr.ac.cr.planDeEstudios.domain.Curso;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

@Service
public class PlanDeEstudioBusiness {
	
	private PlanDeEstudiosData planDao;
	
	
	public List<Curso> calculaPrerequisitos(Curso curso) {

		
		return planDao.calculaPrerequisitos(curso);
	}
	

	
	public boolean insertarPlanEstudio(PlanDeEstudios planDeEstudio) {

		return planDao.insertarPlanEstudio(planDeEstudio);
	}
		
	public void editarPlan(PlanDeEstudios planDeEstudios) {
		
		 planDao.editarPlan(planDeEstudios);
		
		
	}
	
	public void delete(int idPlan) {
	
		
		planDao.delete(idPlan);
	}
}
