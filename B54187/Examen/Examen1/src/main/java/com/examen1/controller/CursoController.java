package com.examen1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examen1.business.cursoBusiness;

@Controller
public class CursoController {

	@Autowired
	private cursoBusiness cursoBusiness;
	
	@RequestMapping(value="/cursos", method=RequestMethod.GET)
	
	public String cursos(Model model) {
		model.addAttribute("cursos", cursoBusiness.retornaLista());
		
		return "cursos";
	}
}
