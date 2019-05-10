package cr.ac.ucr.ie.app.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.ie.app.domain.Empleado;
import cr.ac.ucr.ie.app.domain.Empleados;

@RestController
public class EmpleadosController 
{
	private Empleados empleados = new Empleados();
	
	@RequestMapping("/empleados")
	public @ResponseBody Iterable<Empleado> listar() 
	{
		return empleados.listar();
	}
	
}