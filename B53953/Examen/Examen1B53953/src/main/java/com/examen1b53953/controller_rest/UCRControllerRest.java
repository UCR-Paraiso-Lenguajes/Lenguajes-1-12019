package com.examen1b53953.controller_rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen1b53953.business.CursoBusiness;
import com.examen1b53953.business.PlanBusiness;
import com.examen1b53953.domain.Curso;
import com.examen1b53953.domain.PlanDeEstudio;

@RestController
public class UCRControllerRest {

		@Autowired
		private CursoBusiness cursoBusiness;
		private PlanBusiness planBusiness;
		
		@RequestMapping(value="/ucr/api/cursos", method=RequestMethod.GET )
		public @ResponseBody List<Curso> listarCursos(){
			return cursoBusiness.listarCursos();
		}

		@RequestMapping(value="/ucr/api/GuardarCurso", method=RequestMethod.POST )
		public @ResponseBody Curso insertarCurso(@RequestBody Curso curso)
		{
			curso = cursoBusiness.guardar(curso);
			
			return curso;
		}	

		@RequestMapping(value="/ucr/api/editarCurso", method=RequestMethod.PUT )
		public @ResponseBody void actualizarCurso(
				@RequestBody Curso curso)
		{
			cursoBusiness.editar(curso.getSigla() , curso);
		}

		@RequestMapping(value="/ucr/api/eliminarCurso/{id}", method=RequestMethod.PUT )
		public @ResponseBody void eliminarCurso(
				@PathVariable int id )
		{
			cursoBusiness.eliminar(id);
		}
		
		@RequestMapping(value="/ucr/api/planesDeEstudio", method=RequestMethod.GET )
		public @ResponseBody List<PlanDeEstudio> listarPlanes(){
			return planBusiness.listarPlanes();
		}

		@RequestMapping(value="/ucr/api/GuardarCurso", method=RequestMethod.POST )
		public @ResponseBody Curso insertarPlan(@RequestBody Curso curso)
		{
			curso = planBusiness.guardarPlan(curso);
			
			return curso;
		}	

		@RequestMapping(value="/ucr/api/editarCurso", method=RequestMethod.PUT )
		public @ResponseBody void actualizarPlan(
				@RequestBody Curso curso)
		{
			planBusiness.editarPlan(curso.getSigla() , curso);
		}

		@RequestMapping(value="/ucr/api/eliminarCurso/{id}", method=RequestMethod.PUT )
		public @ResponseBody void eliminarPlan(
				@PathVariable int id )
		{
			planBusiness.eliminarPlan(id);
		}
		
		
}


