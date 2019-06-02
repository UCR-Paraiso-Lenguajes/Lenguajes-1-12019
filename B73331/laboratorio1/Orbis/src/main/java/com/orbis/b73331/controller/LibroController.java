package com.orbis.b73331.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b73331.business.LibroBusiness;

@Controller
public class LibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	
	@RequestMapping(value="/findLibro", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "findLibro";
	}
	@RequestMapping(value="/findLibro2", method=RequestMethod.GET )
	public String buscarPorId(Model model, @RequestParam("id") int id) {
		model.addAttribute("libros", libroBusiness.buscarPorIdEditorial(id));
		return "findLibro";
	}
}
