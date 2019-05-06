package com.orbis.b67156.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b67156.business.LibroBusiness;
import com.orbis.b67156.domain.Libro;

@Controller
public class LibroController {
	
	@Autowired
	private LibroBusiness libroBusiness;
	
	@RequestMapping(value="/VerLibros",method=RequestMethod.GET)
	public String iniciar(Model model) {
		return "VerLibros";
	}
	
	@RequestMapping(value="/mostrar_librosTwo", method=RequestMethod.GET )
	public String mostrar_libros(Model model, @RequestParam("id_editorial") int id_Editorial) {
		
		model.addAttribute("libro", libroBusiness.buscarPorId(id_Editorial));
		return "VerLibros";
		
	}
	
	@RequestMapping(value="/VerLibros",method=RequestMethod.POST)
	public String encuentraLibro (Model model, @RequestParam("id_editorial1") String id_Editorial) {
		int id_editorial_int = Integer.parseInt(id_Editorial);
		Iterator<Libro> libros = libroBusiness.buscarPorId(id_editorial_int);
		model.addAttribute("libro", libros);
		return "VerLibros";
		
	}
}
