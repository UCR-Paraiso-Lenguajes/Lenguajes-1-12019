package cr.ac.ucr.ie.app.controllers.page;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.ie.app.domain.Departamento;
import cr.ac.ucr.ie.app.domain.Departamentos;
import cr.ac.ucr.ie.app.domain.Empleado;
import cr.ac.ucr.ie.app.domain.Empleados;

@Controller
public class HomeController {

	private Departamentos depts = new Departamentos();
	private Empleados empleados = new Empleados();
	
	@RequestMapping("/")
	public String mensaje(ModelMap model) 
	{	
		model.addAttribute("empleados", empleados.listar());
		return "empleados";
	}


	@RequestMapping("/insertarempleado")
	public String insertarEmpleadoPage(ModelMap model) 
	{
		model.addAttribute("departamentos", depts.Listar());

		return "insertarempleado";
	}
	
	@RequestMapping(value="/insertarempleado", method = RequestMethod.POST)
	public void insertarEmpleadoAction(
			/*@RequestBody Empleado empleado*/ 
			HttpServletResponse response,
			@RequestParam String nombre,
			@RequestParam String apellidos,
			@RequestParam int departamento ) throws IOException 
	{
		Departamento dep = depts.BuscarXId(departamento);
		Empleado emp = new Empleado(empleados.BuscarProximoId(),nombre , apellidos,dep);
		empleados.Agregar(emp);

		response.sendRedirect("/");
	}

}
