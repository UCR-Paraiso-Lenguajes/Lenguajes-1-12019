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

import com.videocartago.renting.business.GeneroBusiness;
import com.videocartago.renting.business.PeliculaBusiness;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.form.PeliculaForm;

@Controller
public class InsertarPeliculaController {
	@Autowired
	private GeneroBusiness generoBusiness;
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	@Autowired
	private PeliculasController peliculaController;
	
	@RequestMapping(value="/insertarPelicula", method=RequestMethod.GET)
	public String init (PeliculaForm peliculaForm, Model model) {
		List<Genero>generos = generoBusiness.findAll(1,9999999);
		model.addAttribute("generos",generos);
		model.addAttribute("form",new PeliculaForm());
		return "insertarPelicula";
	}
	
	@RequestMapping(value="/insertarPelicula", method=RequestMethod.POST)
	public String save(@Valid PeliculaForm peliculaForm, BindingResult bindingResult, Model model) throws SQLException {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("generos", generoBusiness.findAll(1, 9999999));
		return "insertarPelicula";
		}else {
			Pelicula pelicula = new Pelicula();
			BeanUtils.copyProperties(peliculaForm, pelicula);
			pelicula.getGenero().setCodGenero(peliculaForm.getCodGenero());
			peliculaBusiness.save(pelicula);
			
			model.addAttribute("peliculas",peliculaBusiness.findAllMoviesByTitleAndGenre(""+pelicula.getGenero(), ""+pelicula.getGenero().getNombreGenero()));
			return peliculaController.findMovies(model, pelicula.getTitulo(),"");
		}
		
	}
	
}
