package com.ucr.ac.cr.planDeEstudios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ucr.ac.cr.planDeEstudios.business.CursoBusiness;
import com.ucr.ac.cr.planDeEstudios.business.PlanDeEstudioBusiness;
import com.ucr.ac.cr.planDeEstudios.domain.Carrera;
import com.ucr.ac.cr.planDeEstudios.domain.Curso;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

@RestController
public class RestControllerUCR {

	@Autowired
	private CursoBusiness cursoBusiness;

	@Autowired
	private PlanDeEstudioBusiness planBusiness;

	@RequestMapping(value = "INSERTAR/PLAN/UCR/API/CARRERAS/{carrera}", method = RequestMethod.POST)
	public ResponseEntity<Object> postInsertarPlan(@PathVariable("planDeEstudios") PlanDeEstudios plan) {

		PlanDeEstudios planDeEstudios = new PlanDeEstudios(plan.getIdPlan(), plan.getNombre(),
				plan.getCantidadDeCursos(), plan.getCreditosTotales(), plan.getCursosInvolucrados());
		planBusiness.insertarPlanEstudio(planDeEstudios);
		return new ResponseEntity<>("Exito", HttpStatus.OK);

	}

	@RequestMapping(value = "EDITAR/PLAN/UCR/API/CARRERAS/{carrera}", method = RequestMethod.PUT)
	public ResponseEntity<Object> postEditarPlan(@PathVariable("planDeEstudios") PlanDeEstudios plan) {

		PlanDeEstudios planDeEstudios = new PlanDeEstudios(plan.getIdPlan(), plan.getNombre(),
				plan.getCantidadDeCursos(), plan.getCreditosTotales(), plan.getCursosInvolucrados());
		planBusiness.editarPlan(planDeEstudios);
		return new ResponseEntity<>("Exito", HttpStatus.OK);

	}

	@RequestMapping(value = "DELETE/PLAN/UCR/API/CARRERAS/{carrera}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> postDeletePlan(@PathVariable("planDeEstudios") PlanDeEstudios plan) {

		planBusiness.delete(plan.getIdPlan());
		return new ResponseEntity<>("Exito", HttpStatus.OK);
	}

	@RequestMapping(value = "INSERTAR/CURSO/UCR/API/CARRERAS/{carrera}", method = RequestMethod.POST)
	public ResponseEntity<Object> postInsertarCurso(@PathVariable("Curso") Curso curso) {

		Curso cursoInsertar = new Curso(curso.getIdCurso(), curso.getNombre(), curso.getSiglas(), curso.getCreditos(),
				curso.getRequisito(), curso.isFinalOrInicial());
		cursoBusiness.insertarCurso(cursoInsertar);
		return new ResponseEntity<>("Exito", HttpStatus.OK);

	}

	@RequestMapping(value = "EDITAR/CURSO/UCR/API/CARRERAS/{carrera}", method = RequestMethod.PUT)
	public ResponseEntity<Object> postEditarCurso(@PathVariable("Curso") Curso curso) {

		Curso cursoEditar = new Curso(curso.getIdCurso(), curso.getNombre(), curso.getSiglas(), curso.getCreditos(),
				curso.getRequisito(), curso.isFinalOrInicial());
		cursoBusiness.editarCurso(cursoEditar);

		return new ResponseEntity<>("Exito", HttpStatus.OK);

	}

	@RequestMapping(value = "DELETE/CURSO/UCR/API/CARRERAS/{carrera}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> postDeleteCurso(@PathVariable("Curso") Curso curso) {

		cursoBusiness.delete(curso.getIdCurso());
		return new ResponseEntity<>("Exito", HttpStatus.OK);
	}
}
