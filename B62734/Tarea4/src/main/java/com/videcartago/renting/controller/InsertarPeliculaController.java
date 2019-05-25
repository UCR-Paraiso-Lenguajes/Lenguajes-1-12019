package com.videcartago.renting.controller;

import java.util.LinkedList;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.videcartago.renting.business.GeneroBusiness;
import com.videcartago.renting.form.PeliculaForm;
import com.videcartago.renting.domain.Genero;


@Controller
public class InsertarPeliculaController {

	@Autowired
	private GeneroBusiness generoBusiness;
	
	@RequestMapping(value="/insertarPelicula", method=RequestMethod.GET)
	public String iniciar(PeliculaForm form, Model model) {		
		model.addAttribute("generos", generoBusiness.findAll(1, 9999999));
		model.addAttribute("form",form);
		return "insertarPelicula";
	}
	
	@RequestMapping(value="/insertarPelicula", method=RequestMethod.POST)
	public String save(@Valid PeliculaForm form, Model model, BindingResult br) {
		return null;
	}
	
	
}
