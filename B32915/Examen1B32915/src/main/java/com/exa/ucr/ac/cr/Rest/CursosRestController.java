package com.exa.ucr.ac.cr.Rest;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exa.ucr.ac.cr.Business.CursosBusiness;
import com.exa.ucr.ac.cr.Domain.Curso;


@RestController
public class CursosRestController {

	/*@Autowired CursosBusiness cursoBusiness;
	Lo tenia con el annotation pero tira un error de bean*/
	
	@RequestMapping(value="/api/carrera/plan/curso", method=RequestMethod.PUT )
	public @ResponseBody void actualizarCurso(@RequestBody Curso curso){
		
		CursosBusiness cursoBusiness = new CursosBusiness();
		
		cursoBusiness.updateCourses(curso);
	}
	
	@RequestMapping(value="/api/carrera/plan/curso/{name}", method=RequestMethod.DELETE )
	public @ResponseBody void eliminaCurso(@PathVariable String name){
		
		CursosBusiness cursoBusiness = new CursosBusiness();
		
		cursoBusiness.deleteCourses(name);
	}
	
	@RequestMapping(value="/api/carrera/plan/curso", method=RequestMethod.POST )
	public @ResponseBody void crearCurso(@RequestBody Curso curso){
		CursosBusiness cursoBusiness = new CursosBusiness();
		
		cursoBusiness.createCourses(curso);
	}
	
	@RequestMapping(value="/api/carrera/plan/curso/{name}", method=RequestMethod.GET )
	public @ResponseBody Iterator<Curso> mostrarCurso(){
		
		CursosBusiness cursoBusiness = new CursosBusiness();
	return	cursoBusiness.getCourses();
	}
	
}
