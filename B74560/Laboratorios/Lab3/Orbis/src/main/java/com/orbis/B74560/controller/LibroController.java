package com.orbis.B74560.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.orbis.B74560.business.LibroBusiness;

@Controller
public class LibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mostrar_libros";
	}
	@RequestMapping(value="/mostrar_librosID", method=RequestMethod.GET )
	public String buscarPorId(Model model, @RequestParam("id") int id) {

		model.addAttribute("libros", libroBusiness.buscarPorEditorial(id));
		return "mostrar_libros";
	}

}
