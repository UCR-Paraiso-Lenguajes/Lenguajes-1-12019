package com.cr.ac.ucr.examen.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.ac.ucr.examen.domain.Curso;
import com.cr.ac.ucr.examen.domain.PlanDeEstudio;

@Service
public class PlanDeEstudiosBusiness {
	
	@Autowired
	CarreraBusiness carreraBusiness;
	
	public void agregarCurso(int carrera, Curso curso) {
		PlanDeEstudio plan = carreraBusiness.obtenerPlan(carrera);
		plan.agregarCurso(curso);
		carreraBusiness.actualizarPlan(carrera, plan);
	}

	public void actualizarCurso(int carrera, int idCurso, Curso curso) {
		PlanDeEstudio plan = carreraBusiness.obtenerPlan(carrera);
		plan.modificarCurso(idCurso, curso);
		carreraBusiness.actualizarPlan(carrera, plan);
	}
	
	public void eliminarCurso(int carrera, int curso) {
		PlanDeEstudio plan = carreraBusiness.obtenerPlan(carrera);
		plan.eliminarCurso(curso);
		carreraBusiness.actualizarPlan(carrera, plan);
	}
	
	public ArrayList<Curso> obtenerCursos(int carrera) {
		PlanDeEstudio plan = carreraBusiness.obtenerPlan(carrera);
		return plan.getCursos();
	}
}
