package com.ucr.ac.cr.planDeEstudios.business;

import java.util.ArrayList;
import java.util.List;

import com.ucr.ac.cr.planDeEstudios.domain.Carrera;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

public class CarreraBusiness {
	
	
private List<Carrera> carreras = new ArrayList<Carrera>();
	

	public List<Carrera> datosCarrera() {
		
		PlanDeEstudios plan = new PlanDeEstudios();
		
		Carrera carrera = new Carrera( );
		carrera.setNombreCarrera("Informatica");
		carrera.setPlanDeEstudios(plan);
		
		carreras.add(carrera);
		
		return carreras;
	}

}
