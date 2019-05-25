package com.videocartago.renting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.videocartago.renting.business.PeliculaBusiness;
import com.videocartago.renting.domain.Pelicula;

	@Controller
	public class PeliculasController {
		@Autowired
		private PeliculaBusiness peliculaBusiness;
		
		@RequestMapping(value="/findMovies", method=RequestMethod.GET )
		public String findMovies(Model model) {
			model.addAttribute("peliculas", peliculaBusiness.findAllMovieByTitle("l"));
			return "findMovies";
		}
		
		
		@RequestMapping(value="/peliculas", method=RequestMethod.GET )
		public @ResponseBody List<Pelicula> PeliculaConMayorDuraciónEnMinutosEntreDosPeliculas(Model model) {
			return peliculaBusiness.findAllMovieByTitle("l");
		}	
	

}
