package com.orbis.B70620.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B70620.ventas.business.EditorialBusiness;

@Controller
public class EditorialController {
	@Autowired
	private EditorialBusiness editorialBusinness;
	
	@RequestMapping(value="/ver_editoriales", method=RequestMethod.GET)
	public String buscarEditorial(Model model) {
		model.addAttribute("editoriales", editorialBusinness.obtenerEditorial());
		return "Editoriales";
	}
	
	@RequestMapping(value="/ver_editoriales1", method=RequestMethod.GET)
	public String buscarEditorial(Model model, 
			@RequestParam("numInicio") int numInicio)
			 {

		model.addAttribute("editoriales", editorialBusinness.obtenerEditorial());
		return "Editoriales";
	}
}
