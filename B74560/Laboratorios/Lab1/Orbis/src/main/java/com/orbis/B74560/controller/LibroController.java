package com.orbis.B74560.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B74560.data.LibroData;


@Controller
public class LibroController {
	
	@Autowired
	private LibroData libroDao;
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mostrar_libros";
	}
	
	@RequestMapping(value="/mostrar_librosTwo", method=RequestMethod.GET )
	public String mostrar_libros(Model model, @RequestParam("id_editorial") int id_Editorial) {
		
		model.addAttribute("libro", libroDao.buscarPorEditorial(id_Editorial));
		return "mostrar_libros";
		
	}
	

	

}
