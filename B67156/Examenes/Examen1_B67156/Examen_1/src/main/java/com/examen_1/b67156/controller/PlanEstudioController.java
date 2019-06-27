package com.examen_1.b67156.controller;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examen_1.b67156.business.PlanEstudioBusiness;
import com.examen_1.b67156.domain.PlanDeEstudio;

@Controller
public class PlanEstudioController {
	
	PlanEstudioBusiness planBusiness = new PlanEstudioBusiness();
	
	@RequestMapping(value="/carreras", method=RequestMethod.GET)
	public String planestudio(Model model){
		return "carreras";
	}
	
}
