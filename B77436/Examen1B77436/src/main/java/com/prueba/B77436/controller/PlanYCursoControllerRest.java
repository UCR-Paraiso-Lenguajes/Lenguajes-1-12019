package com.prueba.B77436.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.B77436.business.PlanEstudioBusiness;
import com.prueba.B77436.domain.Curso;
import com.prueba.B77436.domain.PlandeEstudios;


@RestController
public class PlanYCursoControllerRest {
	
	@Autowired
	private PlanEstudioBusiness planBusiness; 
	@Autowired PlanEstudiosController planController;
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.PUT )
	public @ResponseBody PlandeEstudios update(@PathVariable String carrera, @RequestBody PlandeEstudios plan) {
		if(carrera.equalsIgnoreCase("") ) throw new RuntimeException("El dato viene vacío");
		PlandeEstudios planNuevo =planBusiness.updatePlan(carrera, plan);
		return planNuevo;
	}
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.GET )
	public @ResponseBody PlandeEstudios select(@PathVariable String carrera) {
		if(carrera.equalsIgnoreCase("") ) throw new RuntimeException("El id viene vacío");
		PlandeEstudios planBuscado = planBusiness.selectPlan(carrera);
		return planBuscado;
	}
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.PUT )
	public @ResponseBody void insert(@PathVariable int id, @RequestBody PlandeEstudios plan) {
		if(id<0 ) throw new RuntimeException("El id viene vacío");
		PlandeEstudios insercion = new PlandeEstudios(plan.getNombre(),plan.getCursos(), plan.getCiclos());
	}
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.DELETE )
	public @ResponseBody void delete(@PathVariable String carrera) {
		if(carrera.equals("") ) throw new RuntimeException("El id viene vacío");
		planBusiness.deletePlan(carrera);
	}
	
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}/{idCurso}", method=RequestMethod.PUT )
	public @ResponseBody Curso updateCurso(@PathVariable String carrera, @PathVariable int idCurso, @RequestBody Curso curso) {
		if(carrera.equalsIgnoreCase("") || idCurso<0 ) throw new RuntimeException("El dato viene vacío");
		Curso cursoUpdate = null;
		for(int i=0;i<planController.cursosPlan.size();i++)
			if(planController.cursosPlan.get(i).getIdCurso()==idCurso) {
				cursoUpdate = new Curso(curso.getIdCurso(), curso.getNombre(), curso.getSiglas(), curso.getCreditos(), curso.getRequisitos());
			}
		return cursoUpdate;
	}
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.GET )
	public @ResponseBody Curso selectCurso(@PathVariable int id) {
		if(id<0) throw new RuntimeException("El id viene vacío");
		Curso curso = null;
		for(int i=0;i<planController.cursosPlan.size();i++)
			if(planController.cursosPlan.get(i).getIdCurso()==id)
				curso=planController.cursosPlan.get(i);
		return curso;
	}
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.PUT )
	public @ResponseBody void insertCurso(@PathVariable int id, @RequestBody Curso curso) {
		if(id<0 ) throw new RuntimeException("El id viene vacío");
		Curso cursoInsert = new Curso(curso.getIdCurso(), curso.getNombre(), curso.getSiglas(), curso.getCreditos(), curso.getRequisitos());
	}
	
	@RequestMapping(value="/ucr/api/carrera/{carrera}", method=RequestMethod.DELETE )
	public @ResponseBody void deleteCurso(@PathVariable int id) {
		if(id<0 ) throw new RuntimeException("El id viene vacío");
		for(int i=0;i<planController.cursosPlan.size();i++)
			if(planController.cursosPlan.get(i).getIdCurso()==id)
				planController.cursosPlan.remove(i);
	}
	
	
	
	

}
