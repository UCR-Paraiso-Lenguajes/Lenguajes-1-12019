package com.orbis.B63199.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orbis.B63199.business.AutorBusiness;
import com.orbis.B63199.domain.Autor;

@Controller
public class AutorController {

	@Autowired
	private AutorBusiness autorBusiness;
	/*
	@RequestMapping(value="editarAutor/", method=RequestMethod.PUT)
	public void actualizarAutor(
			@PathVariable int id, 
			@RequestBody Autor autor)
	{
		autorBusiness.update(id, autor);
	}	*/
	
	@RequestMapping(value = "/mantenimientoAutores", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("autores", autorBusiness.obtenerAutores(""));
		model.addAttribute("autoresSize", autorBusiness.obtenerAutores("").size());
		return "mantenimientoAutores";
	}
	
	@RequestMapping(value = "/mantenimientoAutores", method = RequestMethod.POST)
	public String post(Model model, @RequestParam("apellidos") String apellidos) {
		model.addAttribute("autores", autorBusiness.obtenerAutores(apellidos));
		model.addAttribute("autoresSize", autorBusiness.obtenerAutores(apellidos).size());
		return "mantenimientoAutores";
	}

	@RequestMapping(value = "/editarAutor", method = RequestMethod.GET)
	public String editInit(Model model,  @RequestParam("idAutor") int id) {
		model.addAttribute("autor", autorBusiness.obtenerAutorPorId(id));
		return "editarAutor";
	}
	
	@RequestMapping(value = "/eliminarAutor", method = RequestMethod.GET)
	public String eliminarInit(Model model,  @RequestParam("idAutor") int id) {
		model.addAttribute("autor", autorBusiness.obtenerAutorPorId(id));
		return "eliminarAutor";
	}
}
