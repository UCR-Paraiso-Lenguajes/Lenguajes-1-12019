package com.orbis.b40894.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b40894.negocios.LibroLogica;


@Controller
public class LibroControlador {
private int cantidadInicio=1;
 private int cantidadFin=1;

 
 @Autowired
	private LibroLogica libroLogica;
 

@RequestMapping(value="/encontrarLibros", method=RequestMethod.GET )
	public String encontrarLibros(Model model, @RequestParam("idEditorial") int id/*,@RequestParam int cantidadInicio,@RequestParam int cantidadFin*/) {
		
		model.addAttribute("libros", libroLogica.buscarLibro(cantidadInicio,cantidadFin,id));
		return "libro";
	}	
/*@RequestMapping(value="/libros", method=RequestMethod.GET )
	public @ResponseBody Iterator<Libro> datos(Model model, @RequestParam int idEditorial,@RequestParam int cantidadInicio,@RequestParam int cantidadFin) {
	return libroLogica.buscarLibro(cantidadInicio,cantidadFin,idEditorial);
	}*/	
}



