package com.orbis.b40894.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orbis.b40894.ventas.business.AutorBusiness;




@Controller
public class AutorController {
	@Autowired
	private AutorBusiness autorLogica;

@RequestMapping(value="/autor", method=RequestMethod.GET )
	public String encontrarAutor(Model model/*, @RequestParam int cantidadInicio,  @RequestParam int cantidadFin*/) {
		model.addAttribute("autores", autorLogica.findAllAutores());
		return "autores";
	}	

}




