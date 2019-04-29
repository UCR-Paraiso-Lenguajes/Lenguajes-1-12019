package com.orbis.b63685.Laboratorio2Orbis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b63685.Laboratorio2Orbis.business.EditorialBusiness;
import com.orbis.b63685.Laboratorio2Orbis.business.LibroBusiness;

@Controller
public class LibroController {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/verEditoriales", method=RequestMethod.GET)
	public String iniciar(Model model) {
		model.addAttribute("editoriales", editorialBusiness.listarEditoriales());
		return "lista_editoriales";
	}
	
	@RequestMapping(value="/lista_libros", method=RequestMethod.GET)
	public String mostrar(Model model, @RequestParam("idEditorial") int idEditorial) {
		model.addAttribute("libros", libroBusiness.encontrarLibro(idEditorial));

		return "lista_libros";
	}
	

	
}
