package cr.ac.ucr.ie.app.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.ie.app.domain.Departamento;
import cr.ac.ucr.ie.app.domain.Empleado;
import cr.ac.ucr.ie.app.domain.Empleados;

@RestController

public class EmpleadosController 
{
	private Departamento dep = new Departamento(1, "Lenguajes");
	private Empleados empleados = new Empleados();

	
	
	@RequestMapping("/empleados")
	public @ResponseBody Iterable<Empleado> listar() 
	{
		//return dep.listarEmpleados();
		return empleados.listar();
	}
}
