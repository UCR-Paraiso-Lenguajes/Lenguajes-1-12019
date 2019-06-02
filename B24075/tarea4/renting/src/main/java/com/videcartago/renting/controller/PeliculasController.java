package com.videcartago.renting.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.videcartago.renting.business.GeneroBusiness;
import com.videcartago.renting.business.PeliculaBusiness;
import com.videcartago.renting.domain.Genero;
import com.videcartago.renting.domain.Pelicula;
import com.videcartago.renting.domain.form.PeliculaForm;


@Controller
public class PeliculasController {
	@Autowired
	private GeneroBusiness generoBusiness;
	@Autowired
	private PeliculaBusiness peliculaBusiness;
	
	
	@RequestMapping(value="/findMovies", method=RequestMethod.GET )
	public String findMovies(Model model) {
		//TODO capturar los parámetros remitidos desde la vista
		model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGender("the", "suspenso"));
		return "findMovies";
	}
	
	@RequestMapping(value="/insertarPelicula", method=RequestMethod.GET)
    public String init(PeliculaForm peliculaForm, Model model) 
	{
		List<Genero> generos =  generoBusiness.findAll(1, 9999999);
		
		model.addAttribute("generos",generos);
		model.addAttribute("form",new PeliculaForm());
	
		return "insertarPelicula";
    }
	
	@RequestMapping(value = "/insertarPelicula", method = RequestMethod.POST)
	public String save(@Valid PeliculaForm peliculaForm, BindingResult bindingResult, Model model) 
	{
		if (bindingResult.hasErrors())
		{
			model.addAttribute("generos", generoBusiness.findAll(1, 9999999));
			return "insertarPelicula";
		}
		else
		{
			Pelicula pelicula = new Pelicula();
			BeanUtils.copyProperties(peliculaForm, pelicula);
			pelicula.getGenero().setCodGenero(peliculaForm.getCodGenero());
			peliculaBusiness.save(pelicula);
			
			model.addAttribute("peliculas", peliculaBusiness.findAllMoviesByTitleAndGender("it", "suspenso"));
			return "findMovies";
		}
	}
	
	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public String pantallaDEPeliculas() 
	{
		return "peliculas";
	}
}

