package com.cr.ac.ucr.examen.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cr.ac.ucr.examen.business.CarreraBusiness;
import com.cr.ac.ucr.examen.business.PlanDeEstudiosBusiness;
import com.cr.ac.ucr.examen.domain.Carrera;
import com.cr.ac.ucr.examen.domain.Curso;
import com.cr.ac.ucr.examen.domain.PlanDeEstudio;

@RestController
public class UcrController {
	
	@Autowired
	CarreraBusiness carreraBusiness;
	@Autowired
	PlanDeEstudiosBusiness planBusiness;
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}/", method=RequestMethod.GET)
	public @ResponseBody PlanDeEstudio listarPlan (@PathVariable int carrera) {
		return carreraBusiness.obtenerPlan(carrera);
	}
	
	@RequestMapping(value="/ucr/api/carrera/", method=RequestMethod.POST )
	public @ResponseBody Carrera insertarCarrera(@RequestBody Carrera carrera)
	{
		return carreraBusiness.agregar(carrera);
	}	
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}/", method=RequestMethod.PUT )
	public @ResponseBody void actualizar(@PathVariable int idCarrera, @RequestBody Carrera carrera)
	{
		carreraBusiness.actualizar(idCarrera, carrera);
	}
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}/", method=RequestMethod.DELETE )
	public @ResponseBody void eliminar(@PathVariable int carrera)
	{
		carreraBusiness.eliminar(carrera);
	}
	
	@RequestMapping(value="/ucr/api/{carrera}/curso", method=RequestMethod.POST )
	public @ResponseBody void insertarcurso(@PathVariable int carrera , @RequestBody Curso curso)
	{
		planBusiness.agregarCurso(carrera, curso);
	}	
	
	@RequestMapping(value="/ucr/api/{carrera}/curso/{id}", method=RequestMethod.PUT )
	public @ResponseBody void actualizarCurso(@PathVariable int carrera, @PathVariable int idCurso, @RequestBody Curso curso)
	{
		planBusiness.actualizarCurso(carrera, idCurso, curso);
	}
	
	@RequestMapping(value="/ucr/api/{carrera}/curso", method=RequestMethod.DELETE )
	public @ResponseBody void eliminar(@PathVariable int carrera , @RequestBody int curso)
	{
		planBusiness.eliminarCurso(carrera, curso);
	}
}
