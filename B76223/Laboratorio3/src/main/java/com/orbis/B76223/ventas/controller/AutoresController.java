package com.orbis.B76223.ventas.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B76223.ventas.business.AutorBusiness;
import com.orbis.B76223.ventas.domain.Autor;

@Controller
public class AutoresController {

	@Autowired
	AutorBusiness autorBusiness; 
	
	
	@RequestMapping(value = "/verAutores", method = RequestMethod.GET)
	public String listaAutores (Model model) {
		
		model.addAttribute("autores", autorBusiness.findAllAutores(100000, 1000000));
		
		return "verAutores";
	}
	
	@RequestMapping(value = "/verAutores", method = RequestMethod.POST)
	public String listaAutores (Model model,
			@RequestParam("searchApellido") String searchApellido) {
		
		List<Autor> listaAutoresSolicitados = autorBusiness.findAutoresByLastName(searchApellido);
		
		model.addAttribute("autores", autorBusiness.findAutoresByLastName(searchApellido));
		
		return "verAutores";
	}
	
	@RequestMapping(value = "/editarAutor", method = RequestMethod.GET)
	public String editarAutor(Model model, @RequestParam("idAutor") int idAutor) {
		
		model.addAttribute("autor", autorBusiness.findAutoresById(idAutor).get(0));
		return "editarAutor";
	}
	
	@RequestMapping(value = "/eliminarAutor", method = RequestMethod.GET)
	public String eliminarAutor(Model model, @RequestParam("idAutor") int idAutor) {
		
		model.addAttribute("autor", autorBusiness.findAutoresById(idAutor).get(0));
		return "eliminarAutor";
	}
	
}
