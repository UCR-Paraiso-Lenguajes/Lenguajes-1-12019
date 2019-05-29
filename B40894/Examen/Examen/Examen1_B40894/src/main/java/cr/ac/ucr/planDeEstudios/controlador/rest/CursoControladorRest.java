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
import cr.ac.ucr.planDeEstudios.negocios.CursoNegocios;


@RestController
public class CursoControladorRest {

	
	@Autowired
	private CursoNegocios cursoNegocios;
	
	
	@RequestMapping(value="/api/carreras/cursos", method=RequestMethod.GET )
	public @ResponseBody List<Curso> listarCursos()
	{
		return cursoNegocios.listarCursos();
		
	}

	@RequestMapping(value="/api/carrera/cursoInsertar", method=RequestMethod.POST )
	public @ResponseBody Curso insertarCurso(@RequestBody Curso curso)
	{
	curso = cursoNegocios.guardar(curso);
		
		return curso;
	}	

	@RequestMapping(value="/api/carrera/cursoActualizar/{sigla}", method=RequestMethod.PUT )
	public @ResponseBody void actualizarCurso(
			@PathVariable String sigla , 
			@RequestBody Curso curso)
	{
		cursoNegocios.actualizar(curso,sigla);
	}	
	
	@RequestMapping(value="/api/carrera/cursoEliminar/{sigla}", method=RequestMethod.DELETE )
	public @ResponseBody void eliminarCurso(
			@PathVariable String sigla , 
			@RequestBody Curso curso)
	{
		cursoNegocios.eliminar(curso,sigla);
	}
}
