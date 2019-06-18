package com.videocartago.renting.controller;

import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.videocartago.renting.business.GeneroBusiness;
import com.videocartago.renting.business.PeliculaBusiness;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.Stock;
import com.videocartago.renting.form.PeliculaForm;

@Controller
public class PeliculasController {
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	@Autowired
	private GeneroBusiness generoBusiness;	
	
	//private static int inicio=1,fin=5;
	
	
	@RequestMapping(value="/findMovies",method=RequestMethod.GET)
	public String iniciar(Model model, @RequestParam("titulo") String titulo , @RequestParam("genero") String genero) {
		model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre(titulo,genero));
		return "findMovies";
	}
	
	@RequestMapping(value="/peliculas",method=RequestMethod.GET)
	public String iniciar(Model model) {
		return "findMovies";
	}
	
	
	@RequestMapping(value="/insertarPelicula",method=RequestMethod.GET)
	public String init(PeliculaForm peliculaForm,Model model) throws SQLException {
		
		List<Genero> generos = generoBusiness.findAll(1,999999);
		
		model.addAttribute("generos",generos);
		model.addAttribute("peliculaForm",new PeliculaForm());
		
		return "insertarPelicula";
	}
	
	
	@RequestMapping(value="/insertarPelicula",method=RequestMethod.POST)
	public String save(@Valid PeliculaForm peliculaForm,BindingResult bindingResult,Model model) throws SQLException {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("generos",generoBusiness.findAll(1,99999));
			return "insertarPelicula";
		}
		else {
			Pelicula peli = new Stock();
			BeanUtils.copyProperties(peliculaForm,peli);
			peli.setCodPelicula(peliculaForm.getCodPelicula());
			peli.setGenero(new Genero(peliculaForm.getCodGenero(),"Accion"));
			peliculaBusiness.save(peli);
			
			//model.addAttribute("peliculas",peliculaBusiness
			//		.findAllMoviesByTitleAndGenre(peli.getTitulo(),peli.getGenero().getNombreGenero()));
			
			
			model.addAttribute("peliculas",peliculaBusiness.findAllMoviesByTitle(peli.getTitulo()));
			return "findMovies";
		}
	}

}