package com.ucr.ac.cr.Examen1.controller;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ucr.ac.cr.Examen1.data.PlanEstudiosData;
import com.ucr.ac.cr.Examen1.domain.Curso;

@Controller
public class PlanEstudioController {
	

	PlanEstudiosData planDao = new PlanEstudiosData();
	
	@RequestMapping(value = "/mostrar", method = RequestMethod.GET)
	public String home(Model model) {
		planDao.llenarLista();
		ArrayList<Curso> cursos = planDao.ListaCursos;
		model.addAttribute("cursos",  cursos);
		
		return "mostrarPlan";
	}


}
