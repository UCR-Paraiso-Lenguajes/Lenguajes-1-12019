package com.tarea.refugio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tarea.refugio.bussines.AnimalBusiness;


@Controller
public class FindController {
	AnimalBusiness animalBusiness = new AnimalBusiness();
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String buscarAnimales(Model model) {
		model.addAttribute("animales", animalBusiness.listarAnimales());
		return "find";
	}
}
