package com.cr.ac.ucr.examen.business;

import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.ac.ucr.examen.domain.Curso;

import com.cr.ac.ucr.examen.domain.PlanDeEstudio;
import com.cr.ac.ucr.examen.domain.PlanesDeEstudio;

@Service
public class PlanDeEstudiosBusiness {
	
	@Autowired
	PlanesDeEstudio planesDeEstudio;
	
	public ArrayList<Curso> obtenerPlan(String carrera){
		return planesDeEstudio.obtenerPlanesDeEstudio(carrera);
	}

	public PlanDeEstudio agregar(PlanDeEstudio planDeEstudio) {
		return planesDeEstudio.agregar(planDeEstudio);
	}

	public void actualizar(String carrera, PlanDeEstudio plan) {
		planesDeEstudio.modificar(carrera, plan);
	}
	
	public void eliminar(String carrera) {
		planesDeEstudio.eliminar(carrera);
	}
	
	public void agregarCurso(String carrera, Curso curso) {
		planesDeEstudio.agregarCurso(carrera, curso);
	}

	public void actualizarCurso(String carrera, Curso curso) {
		planesDeEstudio.modificarCurso(carrera, curso);
	}
	
	public void eliminarCurso(String carrera, Curso curso) {
		planesDeEstudio.eliminarCurso(carrera, curso);
	}
	

}
