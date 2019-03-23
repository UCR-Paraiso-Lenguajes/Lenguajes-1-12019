package com.videcartago.renting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.videcartago.renting.business.PeliculaBusiness;


@Controller
public class PeliculasController {
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	
	@RequestMapping(value="/findMovies", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "findMovies";
	}
	
	@RequestMapping(value="/findMovies", method=RequestMethod.POST)
	public String findMovies(Model model, @RequestParam("titulo") String titulo,
		@RequestParam("genero") String genero){
			model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre(titulo,genero));
			return "findMovies";
		
	
	}
	
	
}

