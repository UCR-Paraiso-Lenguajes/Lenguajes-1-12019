package com.orbis.B70620.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B70620.ventas.business.LibroBusiness;

@Controller
public class LibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	
	@RequestMapping(value = "/libros", method = RequestMethod.GET)
	public String listarLibros(Model model, @RequestParam("idLib") int editorialId) {
		model.addAttribute("Libros", libroBusiness.obtenerLibrosPorEditorial(editorialId));
		return "Libros";
	}
	
	
}
