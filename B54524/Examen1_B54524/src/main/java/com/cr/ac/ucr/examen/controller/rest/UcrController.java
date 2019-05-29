package com.cr.ac.ucr.examen.controller.rest;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cr.ac.ucr.examen.business.PlanDeEstudiosBusiness;
import com.cr.ac.ucr.examen.domain.Curso;
import com.cr.ac.ucr.examen.domain.PlanDeEstudio;

@RestController
public class UcrController {
	
	@Autowired
	PlanDeEstudiosBusiness estudiosBusiness;
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}/", method=RequestMethod.GET)
	public @ResponseBody Iterator<Curso> listarPlan (@PathVariable String carrera) {
		return estudiosBusiness.obtenerPlan(carrera).iterator();
	}
	
	@RequestMapping(value="/ucr/api/carrera/", method=RequestMethod.POST )
	public @ResponseBody PlanDeEstudio insertarPlan(@RequestBody PlanDeEstudio planDeEstudio)
	{
		planDeEstudio = estudiosBusiness.agregar(planDeEstudio);
		return planDeEstudio;
	}	
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}/", method=RequestMethod.PUT )
	public @ResponseBody void actualizar(
			@PathVariable String carrera , 
			@RequestBody PlanDeEstudio plan)
	{
		estudiosBusiness.actualizar(carrera, plan);
	}
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}/", method=RequestMethod.DELETE )
	public @ResponseBody void eliminar(
			@PathVariable String carrera)
	{
		estudiosBusiness.eliminar(carrera);
	}
	
	@RequestMapping(value="/ucr/api/{carrera}/curso", method=RequestMethod.POST )
	public @ResponseBody void insertarcurso(@PathVariable String carrera , @RequestBody Curso curso)
	{
		estudiosBusiness.agregarCurso(carrera, curso);
	}	
	
	@RequestMapping(value="/ucr/api/{carrera}/curso", method=RequestMethod.PUT )
	public @ResponseBody void actualizarCurso(
			@PathVariable String carrera , 
			@RequestBody Curso curso)
	{
		estudiosBusiness.actualizarCurso(carrera, curso);
	}
	
	@RequestMapping(value="/ucr/api/{carrera}/curso", method=RequestMethod.DELETE )
	public @ResponseBody void eliminar(
			@PathVariable String carrera , 
			@RequestBody Curso curso)
	{
		estudiosBusiness.eliminarCurso(carrera, curso);
	}
}
