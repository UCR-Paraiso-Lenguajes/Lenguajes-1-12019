package cr.ac.ucr.ie.app.controller.pages;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.ie.app.domain.Department;
import cr.ac.ucr.ie.app.domain.Departments;
import cr.ac.ucr.ie.app.domain.Employeer;
import cr.ac.ucr.ie.app.domain.Employeers;

@Controller
public class HomeController {
	private Departments deps = new Departments();
	private Employeers empleados = new Employeers();

	@RequestMapping("/")
	public String mensaje(ModelMap model) {
		model.addAttribute("empleados", empleados.listar());

		return "empleados";
	}

	@RequestMapping("/insertarempleado")

	public String insertarEmpleadoPage(ModelMap model) {
		model.addAttribute("departamentos", deps.Listar());
		return "insertarempleado";
	}

	@RequestMapping(value = "/insertarempleado", method = RequestMethod.POST)
	public void insertarEmpleadoAction(
			/* @RequestBody Empleado empleado */
			HttpServletResponse response, @RequestParam String nombre, @RequestParam String apellidos,
			@RequestParam int departamento) throws IOException {
		Department dep = deps.BuscarXId(departamento);
		Employeer emp = new Employeer(empleados.BuscarProximoId(), nombre, apellidos, dep);
		empleados.Agregar(emp);

		response.sendRedirect("/");
	}
}
