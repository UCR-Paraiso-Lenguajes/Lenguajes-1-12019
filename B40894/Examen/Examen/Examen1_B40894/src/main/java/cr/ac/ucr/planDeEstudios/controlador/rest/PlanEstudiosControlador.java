package cr.ac.ucr.planDeEstudios.controlador.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.planDeEstudios.dominio.Curso;
import cr.ac.ucr.planDeEstudios.dominio.PlanEstudios;
import cr.ac.ucr.planDeEstudios.negocios.PlanEstudiosNegocios;

@RestController
public class PlanEstudiosControlador {

	@Autowired
	private PlanEstudiosNegocios planEstudiosNegocios;

	@RequestMapping(value="/api/carreras/planEstudios", method=RequestMethod.GET )
	public @ResponseBody List<PlanEstudios> listarPlanEstudios()

	{
		return planEstudiosNegocios.listarPlanEstudios();
		
	}
	
	@RequestMapping(value="/api/carreras/planEstudios/asignarCurso", method=RequestMethod.GET )
	public @ResponseBody void asignarCurso(
			@PathVariable Curso curso , 
			@RequestBody PlanEstudios plan)
	{
		planEstudiosNegocios.asignarCurso(curso, plan);
	}	
	
}
