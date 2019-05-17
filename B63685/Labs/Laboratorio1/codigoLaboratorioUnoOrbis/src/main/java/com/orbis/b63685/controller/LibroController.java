package com.orbis.b63685.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b63685.business.EditorialBusiness;
import com.orbis.b63685.business.LibroBusiness;

@Controller
public class LibroController {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/mostrarEditoriales", method=RequestMethod.GET)
	public String iniciar(Model model) {
		model.addAttribute("editoriales", editorialBusiness.listarEditoriales());
		return "/view/verEditoriales";
	}
	
	
	@RequestMapping(value="/mostrarLibros", method=RequestMethod.GET)
	public String mostrar(Model model, @RequestParam("idEditorial") int codEditorial,@RequestParam("nombre") String nombre) {
		model.addAttribute("libros", libroBusiness.buscarPorEditorial(codEditorial));
		model.addAttribute("nombre",nombre);
		return "/view/mostrarLibros";
	}
	

	
}