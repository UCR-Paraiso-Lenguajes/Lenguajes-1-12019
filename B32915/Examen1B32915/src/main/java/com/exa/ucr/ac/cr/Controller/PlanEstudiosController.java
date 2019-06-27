package com.exa.ucr.ac.cr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exa.ucr.ac.cr.Business.PlanEstudiosBusiness;

@Controller
public class PlanEstudiosController {
	
	@RequestMapping(value="/planEstudios", method=RequestMethod.GET)
    public String mainScreen(Model model) 
	{
		 PlanEstudiosBusiness planBusiness = new PlanEstudiosBusiness();
		 
		String planName = planBusiness.planEstudio.getName();
		
		model.addAttribute("namePlan", planName);
		model.addAttribute("cursos", planBusiness.coursesByPlan());
		
		return "planEstudios";
    }
	
}
