package com.ucr.ac.cr.planDeEstudios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ucr.ac.cr.planDeEstudios.business.PlanDeEstudioBusiness;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

@Controller
public class ControllerListaCurso {

	
	@Autowired
	private PlanDeEstudioBusiness planBusiness;
	
	@RequestMapping(value="/listar_cursos", method=RequestMethod.GET)	
		public String listarCursos(Model model) {
		
			model.addAttribute("cursos", planBusiness.datosPlanDeEstudio());
			return "listar_cursos";
		
			
		
	}
}
