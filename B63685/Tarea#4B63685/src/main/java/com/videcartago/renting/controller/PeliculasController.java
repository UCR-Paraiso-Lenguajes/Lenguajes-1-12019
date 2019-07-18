package com.videcartago.renting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videcartago.renting.business.PeliculaBusiness;
import com.videcartago.renting.domain.Pelicula;


@Controller
public class PeliculasController {
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	
	@RequestMapping(value="/findMovies", method=RequestMethod.GET )
	public String findMovies(Model model) {
		//TODO capturar los parámetros remitidos desde la vista
		model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre("the", "suspenso"));
		return "findMovies";
	}
	
	
	@RequestMapping(value="/peliculas", method=RequestMethod.GET )
	public @ResponseBody List<Pelicula> PeliculaConMayorDuraciónEnMinutosEntreDosPeliculas(Model model) {
		return peliculaBusiness.findAllMoviesByTitleAndGenre("the", "suspenso");
	}	
}

