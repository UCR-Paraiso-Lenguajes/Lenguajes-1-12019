package com.orbis.b63685.Laboratorio1Orbis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b63685.Laboratorio1Orbis.business.AutorBusiness;
import com.orbis.b63685.Laboratorio1Orbis.domain.Autor;

@Controller
public class AutorController {

	
	@Autowired
	private AutorBusiness autorBusiness;
	
	@RequestMapping(value="/mantenimientoAutores", method=RequestMethod.GET)	
	public String mantenimientoAutores(Model model,@ModelAttribute(name="autor") Autor autor) {
		
		return "mantenimientoAutores";
		
		
		
	}
	
	
	
	
	 @RequestMapping(value="/mantenimientoAutores", method=RequestMethod.POST)
	public String muestraAutores(@ModelAttribute(name="autor") Autor autor, Model model) {
		
			
		String lastName = autor.getApellidosAutor();
		
		model.addAttribute("autores", autorBusiness.findAuthorByLastName(lastName));
		
		return "mantenimientoAutores";
		
		
	}
	 
	 @RequestMapping(value="/editarAutor", method=RequestMethod.GET)
		public String mostrar(Model model, @RequestParam("idAutor") int idAutor) {
			

			return "editarAutor";
		}
	 
	 
	 @RequestMapping(value="/borrarAutor", method=RequestMethod.GET)
		public String borrar(Model model, @RequestParam("idAutor") int idAutor) {
			

			
			return "borrarAutor";
		}
		
		
	
}
