package com.orbis.b73027.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.orbis.b73027.data.LibroData;


@Controller
public class LibroController {
	
	@Autowired
	private LibroData libroNegocios;
	
	@RequestMapping(value="/mostrarLibros", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "mostrarLibros";
	}
	
	@RequestMapping(value="/mostrarLibros2", method=RequestMethod.GET )
	public String mostrar_libros(Model model, @RequestParam("id_editorial")String idEditorial){
		int idEditorialTemp = Integer.parseInt(idEditorial);
		model.addAttribute("libro", libroNegocios.searchPorEditorial(idEditorialTemp));
		return "mostrarLibros";
	}
	

	

}
