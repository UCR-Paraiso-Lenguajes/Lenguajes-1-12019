package cr.ac.ucr.planDeEstudios.controlador.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.planDeEstudios.dominio.Carrera;
import cr.ac.ucr.planDeEstudios.negocios.CarreraNegocios;

@RestController
public class CarreraControlador {

	@Autowired
	private CarreraNegocios carreraNegocios;

	@RequestMapping(value="/api/carreras", method=RequestMethod.GET )
	public @ResponseBody List<Carrera> listarCarreras()

	{
		return carreraNegocios.listarCarreras();
		
	}
	
	
	
}
