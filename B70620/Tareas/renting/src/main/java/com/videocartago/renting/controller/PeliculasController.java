package com.videocartago.renting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videocartago.renting.business.PeliculaBusiness;
import com.videocartago.renting.domain.Pelicula;




@Controller
public class PeliculasController {
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	
	
	 @RequestMapping(value="/verPeliculas", method=RequestMethod.GET )
	public String findMovies(Model model) {
		
		//TODO capturar los parámetros remitidos desde la vista
		model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre("the", "co"));
		return "verPeliculas";
	}
	
	
	@RequestMapping(value="/verPeliculas", method=RequestMethod.POST)
	public String findMovies(Model model, @RequestParam("titulo") String titulo,
			@RequestParam("genero") String genero) {
		model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre(titulo, genero));
		return "verPeliculas";
	}
	
	
	@RequestMapping(value="/peliculas", method=RequestMethod.GET )
	public @ResponseBody List<Pelicula> verListaPeliculas(Model model) {
		return peliculaBusiness.findAllMoviesByTitleAndGenre("", "");
	}
	
}