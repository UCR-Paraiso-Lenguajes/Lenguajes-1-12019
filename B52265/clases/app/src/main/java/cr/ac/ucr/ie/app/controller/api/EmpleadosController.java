package cr.ac.ucr.ie.app.controller.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cr.ac.ucr.ie.app.domain.Department;
import cr.ac.ucr.ie.app.domain.Employeer;
import cr.ac.ucr.ie.app.domain.Employeers;

@RestController
public class EmpleadosController {
	private Employeers empleados = new Employeers();

	@RequestMapping("/empleados")
	public @ResponseBody Iterable<Employeer> listar() {
		return empleados.listar();
	}
}
