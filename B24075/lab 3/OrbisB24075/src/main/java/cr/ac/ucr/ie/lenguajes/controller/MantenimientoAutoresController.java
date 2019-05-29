package cr.ac.ucr.ie.lenguajes.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.ie.lenguajes.business.AutorBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Autor;

@Controller
public class MantenimientoAutoresController {

	@Autowired
	private AutorBusiness autorBusiness;

	private Autor autorActual;

	private List<Autor> autores = new  ArrayList<Autor>(); 
	
	@RequestMapping(value = "/mantenimientoAutores", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("autores", autores);
		return "mantenimientoAutores";
	}

	@RequestMapping(value = "/mantenimientoAutores/buscar", method = RequestMethod.POST)
	public String buscar(@RequestParam Map<String, String> requestParams, Model model) {
		String apellidos = requestParams.get("apellidos");
		if (!apellidos.equals("")) {
			autores = autorBusiness.buscarAutoresApellidos(apellidos);
			model.addAttribute("autores", autores);
		}

		return "mantenimientoAutores";
	}

	@RequestMapping(value = "/eliminarAutor/{id}/**", method = RequestMethod.GET)
	public String remove(@PathVariable String id, HttpServletRequest request, Model model) {

		String var = (new AntPathMatcher().extractPathWithinPattern("/{id}/**", request.getRequestURI()));
		int codAutor = Integer.parseInt(var);

		autorActual = autorBusiness.findAutorById(codAutor);

		model.addAttribute("autorActual", autorActual);

		return "eliminarAutor";

	}

	@RequestMapping(value = "/eliminarAutor/accept", method = RequestMethod.GET)
	public String accept(Model model) {

		try {
			autorBusiness.remove(autorActual.getIdAutor());
		} catch (SQLException e) {

			model.addAttribute("mensaje", "Ocurrio un error a la hora de borrar el autor");

			return "error";
		}
		model.addAttribute("mensaje", "El autor fue borrado con exito");
		return "success";
	}

	@RequestMapping(value = "/actualizarAutor/{id}/**", method = RequestMethod.GET)
	public String update(@PathVariable String id, HttpServletRequest request, Model model) {

		String var = (new AntPathMatcher().extractPathWithinPattern("/{id}/**", request.getRequestURI()));
		int codAutor = Integer.parseInt(var);

		autorActual = autorBusiness.findAutorById(codAutor);

		String nombre = autorActual.getNombre();

		model.addAttribute("autorActual", autorActual);

		return "actualizarAutor";

	}
	
	@RequestMapping(value = "/actualizarAutor/actualizar", method = RequestMethod.POST)
	public String actualizar(@RequestParam Map<String, String> requestParams, Model model) {
		String nombre = requestParams.get("nombre");
		String apellido = requestParams.get("apellidos");
		int id = autorActual.getIdAutor();
		
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(id);
		

		try {
			autorBusiness.update(id,nombre,apellido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return "success";
	}

	
}
