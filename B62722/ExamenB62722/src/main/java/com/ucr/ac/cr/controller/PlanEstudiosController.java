package com.ucr.ac.cr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ucr.ac.cr.business.PlanEstudiosBusiness;
import com.ucr.ac.cr.domain.Curso;

@Controller
public class PlanEstudiosController {

	@Autowired
	private PlanEstudiosBusiness planEstudiosBusiness;
	
	@RequestMapping(value="/planEstudios", method=RequestMethod.GET)
	public String mostrarPlan(Model model) {
		model.addAttribute("cursos" , planEstudiosBusiness.mostrarPlanEstudios());
		return "planEstudios";
	}
}
