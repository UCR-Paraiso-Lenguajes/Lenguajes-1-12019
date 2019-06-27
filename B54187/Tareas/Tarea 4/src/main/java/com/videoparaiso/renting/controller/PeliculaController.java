package com.videoparaiso.renting.controller;

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

import com.videoparaiso.renting.business.PeliculaBusiness;
import com.videoparaiso.renting.form.PeliculaForm;
import com.videoparaiso.renting.business.GeneroBusiness;
import com.videoparaiso.renting.domain.EstadoStock;
import com.videoparaiso.renting.domain.EstadoPelicula;
import com.videoparaiso.renting.domain.EstadoRentada;
import com.videoparaiso.renting.domain.Genero;
import com.videoparaiso.renting.domain.Pelicula;

@Controller
public class PeliculaController {

	@Autowired
	private GeneroBusiness generoBusiness;
	@Autowired
	private PeliculaBusiness peliculaBusiness; 

	@RequestMapping(value="/insertarPelicula", method=RequestMethod.GET)
    public String init(PeliculaForm peliculaForm, Model model) 
	{
		List<Genero> generos =  generoBusiness.findAll();
		
		model.addAttribute("generos",generos);
		model.addAttribute("form",peliculaForm);
	
		return "insertarPelicula";
    }
	

	@RequestMapping(value = "/insertarPelicula", method = RequestMethod.POST)
	public String save(@Valid PeliculaForm peliculaForm, BindingResult bindingResult, Model model) 
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("generos", generoBusiness.findAll());
			return "insertarPelicula";
		}
		else
		{
			Pelicula pelicula = new Pelicula();
			BeanUtils.copyProperties(peliculaForm, pelicula);
			pelicula.getGenero().setCodGenero(peliculaForm.getCodGenero());
			try {
				peliculaBusiness.save(pelicula);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre("it", "suspenso"));
			return "findMovies";
		}
	}
	
	@RequestMapping(value = "/findMovies", method = RequestMethod.GET)
	public String iniciar(Model model) {
		return "findMovies";
	}

	@RequestMapping(value = "/findMovies", method = RequestMethod.POST)
	public String findMovies(Model model, @RequestParam("titulo") String titulo,
			@RequestParam("genero") String genero) {
		model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGenre(titulo, genero));
		return "findMovies";

	}
	
}
