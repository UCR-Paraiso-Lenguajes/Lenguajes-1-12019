package com.orbis.b62722.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orbis.b62722.business.EditorialBusiness;
import com.orbis.b62722.business.LibroBusiness;

@Controller
public class LibroController {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;

	@RequestMapping(value="/editoriales", method=RequestMethod.GET)
    public String iniciar(Model model) {
		model.addAttribute("editoriales",editorialBusiness.buscarEditorial());
        return "ver_editoriales";
    }
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET)
    public String buscarPorEditorial(int id_editorial, Model model) {
		model.addAttribute("libros", libroBusiness.buscarLibro(id_editorial));
        return "mostrar_libros";
    }
}
