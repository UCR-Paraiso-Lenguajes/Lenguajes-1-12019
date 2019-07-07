package ControllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Business.CursoBusiness;
import Business.PlanEstudiosBusiness;
import Domain.Curso;
import Domain.PlanEstudios;

@RestController
public class CursoControllerRest {

	@Autowired
	private CursoBusiness cursosBusiness;
	
	@RequestMapping(value="ucr/api/carreras/cursos", method=RequestMethod.GET)
	public @ResponseBody void verPlan( PlanEstudios plan
			) {
		cursosBusiness.listarCursosPorPlan(plan);
	}
	
	@RequestMapping(value="ucr/api/cursos", method=RequestMethod.PUT )
	public @ResponseBody void actualizarCursos(Curso curso, PlanEstudios plan)
	{
		cursosBusiness.editarCurso(curso, plan);
	}

	@RequestMapping(value="/api/eliminarCursos", method=RequestMethod.POST )
	public void eliminarCurso(
	@PathVariable  PlanEstudios plan, 
	@PathVariable Curso curso)
	{
		cursosBusiness.eliminarCurso(curso, plan);
	
	}
}
