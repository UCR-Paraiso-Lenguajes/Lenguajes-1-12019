package com.cr.ac.ucr.examen.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cr.ac.ucr.examen.domain.PlanDeEstudio;
import com.cr.ac.ucr.examen.domain.Carrera;
import com.cr.ac.ucr.examen.domain.Carreras;

@Service
public class CarreraBusiness {
	
	@Autowired
	Carreras carreras;
	
	public PlanDeEstudio obtenerPlan(int id){
		return carreras.obtenerPlanDeEstudio(id);
	}

	public Carrera agregar(Carrera carrera) {
		return carreras.agregar(carrera);
	}

	public void actualizar(int id, Carrera carrera) {
		carreras.modificar(id, carrera);
	}
	
	public void eliminar(int id) {
		carreras.eliminar(id);
	}
	
	public void actualizarPlan (int id, PlanDeEstudio planDeEstudio) {
		carreras.actualizarPlan(id, planDeEstudio);
	}
}
