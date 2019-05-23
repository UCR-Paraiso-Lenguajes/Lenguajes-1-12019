package com.orbis.B70620.ventas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orbis.B70620.ventas.business.AutorBusiness;
import com.orbis.B70620.ventas.domain.Autor;


@Controller
public class AutorController {

	@Autowired
	private AutorBusiness autorBusinness;
	
	
	@RequestMapping(value="/mantenimientoautores", method=RequestMethod.GET)
	public String buscarAutores(Model model) {
		model.addAttribute("autor", new Autor());
		model.addAttribute("autores", autorBusinness.obtenerAutoresPorApellidos(""));
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value="/mantenimientoautores", method=RequestMethod.POST)
	public String buscarAutoresPorApellidos(Model model, Autor autor) {
		model.addAttribute("autor", autor);
		model.addAttribute("autores", autorBusinness.obtenerAutoresPorApellidos(autor.getApellidos()));
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value = "/editarautor", method = RequestMethod.GET)
	public String editarAutor(Model model,@RequestParam("id") int id,
							  @RequestParam("apellidos") String apellidos,
							  @RequestParam("nombre") String nombre) {
		model.addAttribute("autor", new Autor(id, nombre, apellidos));
		return "editarAutor"; 
	}
	

	@RequestMapping(value = "/eliminarautor", method = RequestMethod.GET)
	public String eliminarAutor(Model model,@RequestParam("id") int id,
							  @RequestParam("apellidos") String apellidos,
							  @RequestParam("nombre") String nombre) {
		model.addAttribute("autor", new Autor(id, nombre, apellidos));
		return "eliminarAutor"; 
	}
}
