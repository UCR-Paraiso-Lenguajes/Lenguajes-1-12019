package com.orbis.B76223.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B76223.ventas.business.EditorialBusiness;
import com.orbis.B76223.ventas.domain.Editorial;

@Controller
public class EditorialController {

	@Autowired
	private EditorialBusiness editorialBusiness;
	
	
	@RequestMapping(value = "/verEditoriales", method = RequestMethod.GET)
	public String listarEditorial(Model model) {
		model.addAttribute("editoriales", editorialBusiness.listarEditorial(1, 3));
		return "verEditoriales";
	}
	
	
	@RequestMapping(value = "/verEditoriales1", method = RequestMethod.GET)
	public String listarEditorial(Model model,@RequestParam("numInicio") int numInicio,
			@RequestParam("numFinal") int numFinal) {
		model.addAttribute("editoriales", editorialBusiness.listarEditorial(numInicio, numFinal));
		return "verEditoriales";
	}
	

	@RequestMapping(value = "/verLibros", method = RequestMethod.GET)
	public String listarLibros(Model model, @RequestParam("idLib") int idEditorial) {
		model.addAttribute("libros", editorialBusiness.listarLibrosPorEditorial(idEditorial));
		return "verLibros";

	}
}
