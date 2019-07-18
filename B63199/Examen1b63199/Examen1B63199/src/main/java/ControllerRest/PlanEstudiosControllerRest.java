package ControllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Business.PlanEstudiosBusiness;
import Domain.Curso;
import Domain.PlanEstudios;

@RestController
public class PlanEstudiosControllerRest {

	@Autowired
	private PlanEstudiosBusiness planEstudiosBusiness;
	
	@RequestMapping(value="ucr/api/carreras/planEstudios", method=RequestMethod.GET)
	public @ResponseBody void verPlan( PlanEstudios plan
			) {
		planEstudiosBusiness.getPlan(plan);
	}
	
	@RequestMapping(value="ucr/api/planEstudios", method=RequestMethod.PUT )
	public @ResponseBody void actualizarCursos( 
	@RequestBody PlanEstudios plan)
	{
		planEstudiosBusiness.editarPlan(plan);
	}

	@RequestMapping(value="/api/eliminarPlan", method=RequestMethod.POST )
	public void eliminarCurso(
	@PathVariable  PlanEstudios plan)
	{
		planEstudiosBusiness.eliminarPlan(plan); 
	
	}
}
