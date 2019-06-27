package com.ucr.ac.cr.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucr.ac.cr.business.PlanEstudiosBusiness;
import com.ucr.ac.cr.domain.Curso;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private PlanEstudiosBusiness planEstudiosBusiness;
	
	@RequestMapping(value="/ucr/api/carreras", method=RequestMethod.POST)
	public @ResponseBody Curso insertarCurso(@RequestBody Curso curso) {
		planEstudiosBusiness.añadirCurso(curso);
		return curso;
	}
	
	@RequestMapping(value="/ucr/api/carreras", method=RequestMethod.GET)
	public @ResponseBody List<Curso> listarCursos() {
		return planEstudiosBusiness.mostrarPlanEstudios();
	}

	@RequestMapping(value = "/ucr/api/carreras/{carrera}", method = RequestMethod.PUT)
	public @ResponseBody void actualizarCurso(@PathVariable String nombre, @RequestBody Curso curso) {
		planEstudiosBusiness.actualizarCurso(nombre, curso);
	}

	@RequestMapping(value = "/ucr/api/carreras/{carrera}", method = RequestMethod.DELETE)
	public @ResponseBody void borrarCurso(@PathVariable String nombre, @RequestBody Curso curso) {
		planEstudiosBusiness.eliminarCurso(nombre, curso);
	}
	
}
