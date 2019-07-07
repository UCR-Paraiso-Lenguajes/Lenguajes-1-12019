package com.lenguajes.examen.examen1.business;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lenguajes.examen.examen1.domain.PlanEstudios;
import com.lenguajes.examen.examen1.excepciones.PlanEstudiosException;

public class PlanEstudiosBusiness {
	@Autowired
	private ArrayList<PlanEstudios> planesEstudios;
	
	public void crear(PlanEstudios planEstudios) {
		if (planesEstudios.contains(planEstudios)) {
			throw new PlanEstudiosException("el plan de estudios ya existe");
		}else {
			planesEstudios.add(planEstudios);
		}
	}
	public void actualizar(PlanEstudios planEstudiosViejo,PlanEstudios planEstudiosNuevo) {
		if (!planesEstudios.contains(planEstudiosViejo)) {
			throw new PlanEstudiosException("el plan de estudios no existe");
		}else {
			planesEstudios.set(planesEstudios.indexOf(planEstudiosViejo), planEstudiosNuevo);
		}
	}
	public void delete(String carrera) {
		PlanEstudios planEstudios=getPlanPorCarrera(carrera);
		if (!planesEstudios.contains(planEstudios)) {
			throw new PlanEstudiosException("el plan de estudios ya existe");
		}else {
			planesEstudios.remove(planEstudios);
		}
	}
	public PlanEstudios getPlanPorCarrera(String carrera) {
		PlanEstudios planEstudios=null;
		for (int planes = 0; planes < planesEstudios.size(); planes++) {
			if (planesEstudios.get(planes).getNombre().equals(carrera)) {
				planEstudios=planesEstudios.get(planes);
			}
		}
		return planEstudios;
	}
	public ArrayList<PlanEstudios> listar() {
		return planesEstudios;
	}
	
}
