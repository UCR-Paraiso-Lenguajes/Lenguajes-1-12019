package com.orbis.b63199.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orbis.b63199.dominio.Editorial;
import com.orbis.b63199.logica.EditorialLogica;

@Controller
public class editorialControlador {
	@Autowired
	private EditorialLogica editorialLogica;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String findMovies(Model modelo) {
		modelo.addAttribute("editoriales", editorialLogica.buscarEditorial(1,100));
		System.out.print(editorialLogica.buscarEditorial(1,100));
		return "a";
	}
	
	/*
	@RequestMapping(value="/editoriales", method=RequestMethod.GET )
	public @ResponseBody List<Editorial> datos(Model model) {
		return editorialLogica.buscarEditorial(5,10);
	}	*/
}
