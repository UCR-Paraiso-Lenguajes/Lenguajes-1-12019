package ControllerRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Business.CursoBusiness;
import Domain.Curso;


@RestController
public class CursoControllerRest {

	private CursoBusiness cursoBusiness;
	
	@RequestMapping(value="/api/insertarCurso", method=RequestMethod.POST)
	public @ResponseBody void actualizarAutor(
			@RequestBody Curso curso)
	{
		cursoBusiness.actualizarEstado();
	}
		
	
}
