package com.orbis3.b53953.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis3.b53953.business.AutorBusiness;


@Controller
public class AutorController {

	@Autowired
	private AutorBusiness autorBusiness;

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