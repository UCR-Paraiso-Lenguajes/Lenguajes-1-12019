package com.orbis.b62722.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orbis.b62722.business.LibroBusiness;

@Controller
public class LibroController {

	private LibroBusiness libroBusiness;
	
	@RequestMapping(value="/ver_editoriales", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "ver_editoriales";
		
	}
	
	public String buscarPorEditorial(Model model, int idEditorial) {
		return null;
		
	}
}
