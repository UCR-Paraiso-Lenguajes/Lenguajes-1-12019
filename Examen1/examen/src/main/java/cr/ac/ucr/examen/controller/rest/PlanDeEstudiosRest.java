package cr.ac.ucr.examen.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.examen.business.CarreraBusiness;
import cr.ac.ucr.examen.domain.Carrera;
import cr.ac.ucr.examen.domain.Ciclo;
import cr.ac.ucr.examen.domain.Curso;


@RestController
public class PlanDeEstudiosRest {



	@Autowired
	private CarreraBusiness carreraBusiness;
	
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}",method=RequestMethod.GET )
	public @ResponseBody List<Carrera> listarCarreras(@RequestParam(value="siglas") String siglas) 
	{
		return carreraBusiness.listar(siglas);
	
	}
	
	@RequestMapping(value="/ucr/api/carreras/{carrera}",method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Carrera insertarCarrerra(@RequestBody Carrera carrera) {
		carreraBusiness.insertar(carrera);
		return carrera;
	}
	


	@RequestMapping(value="/ucr/api/carreras/{siglas}",method=RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void actualizarPelicula(@PathVariable String siglas ,@RequestBody Carrera carrera) {
		carreraBusiness.actualizar(siglas,carrera);
	}
	
	
	@RequestMapping(value="/ucr/api/carreras/{siglas}",method=RequestMethod.DELETE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void eliminarPelicula(@PathVariable String siglas) {
		carreraBusiness.eliminar(siglas);
	}
	
	
	
	@RequestMapping(value="/ucr/api/carreras/curso/{curso}",method=RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Curso insertarCurso(@RequestBody Curso curso,@RequestBody Ciclo ci) {
		carreraBusiness.insertarCursosCarrera(curso, ci);
		return curso;
	}
	
	
	

}
