package com.orbis.B77436.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B77436.business.EditorialBusiness;
import com.orbis.B77436.business.LibroBusiness;

@Controller
public class LibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mostrar_libros";
	}
	
	@RequestMapping(value="/mostrar_libros2", method=RequestMethod.GET )
	public String mostrar_libros(Model model, @RequestParam("id_editorial") String id_editorialRequest) {
		int id_editorial = Integer.parseInt(id_editorialRequest);
		model.addAttribute("libro", libroBusiness.buscarId(id_editorial));
		return "mostrar_libros";
	}
	

	

}
