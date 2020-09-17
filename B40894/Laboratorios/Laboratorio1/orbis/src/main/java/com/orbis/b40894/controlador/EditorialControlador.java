package com.orbis.b40894.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.orbis.b40894.negocios.EditorialLogica;



@Controller
public class EditorialControlador {
private int cantidadInicio=1;
private int cantidadFin=2;
	@Autowired
	private EditorialLogica editorialLogica;

@RequestMapping(value="/editorial", method=RequestMethod.GET )
	public String encontrarLibros(Model model/*,   int cantidadInicio,  @RequestParam int cantidadFin*/) {
		model.addAttribute("editoriales", editorialLogica.buscarEditorial(cantidadInicio, cantidadFin));
		return "editorial";
	}	
/*@RequestMapping(value="/editorial2", method=RequestMethod.GET )
	public @ResponseBody Iterator<Editorial> datos(Model model, @RequestParam int cantidadInicio,  @RequestParam int cantidadFin) {
		return editorialLogica.buscarEditorial(cantidadInicio, cantidadFin);
	}*/	
}




