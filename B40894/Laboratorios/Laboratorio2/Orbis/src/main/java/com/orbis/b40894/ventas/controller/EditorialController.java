package com.orbis.b40894.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.orbis.b40894.ventas.business.EditorialBusiness;



@Controller
public class EditorialController {
private int cantidadInicio=1;
private int cantidadFin=2;
	@Autowired
	private EditorialBusiness editorialLogica;

@RequestMapping(value="/editorial", method=RequestMethod.GET )
	public String encontrarLibros(Model model/*, @RequestParam int cantidadInicio,  @RequestParam int cantidadFin*/) {
		model.addAttribute("editoriales", editorialLogica.findEditorial(cantidadInicio, cantidadFin));
		return "editorial";
	}	
	
}




