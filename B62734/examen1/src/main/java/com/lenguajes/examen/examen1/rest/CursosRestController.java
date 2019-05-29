package com.lenguajes.examen.examen1.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lenguajes.examen.examen1.business.CursoBusiness;
import com.lenguajes.examen.examen1.domain.Curso;

@RestController
public class CursosRestController {
	CursoBusiness cursoBusiness=new CursoBusiness();
	
 	@RequestMapping(value="/api/cursos/{nombre}/{siglas}/{creditos}", method=RequestMethod.POST )
	public @ResponseBody void Crear(
			@RequestBody String nombre,
			@RequestBody String siglas,
			@RequestBody int creditos){
 		
 		Curso Curso=new Curso(nombre,siglas,creditos);
		cursoBusiness.crear(Curso);
	}
 	@RequestMapping(value="/api/eliminarCursos/{nombre}", method=RequestMethod.DELETE)
	public @ResponseBody void eliminar(
			@RequestBody String nombre){
		cursoBusiness.delete(nombre);
	}
 	@RequestMapping(value="/api/updateCursos/{Curso}/{CursoNuevo}", method=RequestMethod.PUT )
	public @ResponseBody void actualizar(
			@RequestBody Curso Curso,
			@RequestBody Curso CursoNuevo){
 		
		cursoBusiness.actualizar(Curso,CursoNuevo);
	}
 	@RequestMapping(value="/api/listarCurso/", method=RequestMethod.GET )
	public @ResponseBody ArrayList<Curso> listar(){
 		
		return cursoBusiness.listar();
	}
}
