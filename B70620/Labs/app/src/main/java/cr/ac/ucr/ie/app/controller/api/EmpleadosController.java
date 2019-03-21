package cr.ac.ucr.ie.controller;




import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cr.ac.ucr.ie.domain.Departamento;
import cr.ac.ucr.ie.domain.Empleado;


@RestController
public class EmpleadosController {
	
	private Departamento dep = new Departamento(1, "Lenguajes");


	@RequestMapping("/")
	public @ResponseBody List<Empleado> listar() {
		return dep.listarEmpleados();
	
	}

}
