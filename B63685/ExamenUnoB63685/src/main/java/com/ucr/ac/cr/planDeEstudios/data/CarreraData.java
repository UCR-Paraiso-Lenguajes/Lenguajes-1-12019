package com.ucr.ac.cr.planDeEstudios.data;

import java.util.ArrayList;
import java.util.List;

import com.ucr.ac.cr.planDeEstudios.domain.Carrera;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

public class CarreraData {
	
	
	private List<Carrera> carreras = new ArrayList<Carrera>();
	

	public boolean insertarCarrera(Carrera carrera) {

		boolean carreraInsertada = false;

		if (!carreras.contains(carrera)) {
			carreras.add(carrera);
			carreraInsertada = true;
		}

		return carreraInsertada;

	}

}
