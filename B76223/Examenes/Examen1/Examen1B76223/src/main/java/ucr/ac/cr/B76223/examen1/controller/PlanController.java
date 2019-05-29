package ucr.ac.cr.B76223.examen1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ucr.ac.cr.B76223.examen1.business.PlanBusiness;
import ucr.ac.cr.B76223.examen1.domain.Plan;

@Controller
public class PlanController {

	@Autowired
	PlanBusiness planBusiness; 
	
	@RequestMapping(value = "/verPlan", method = RequestMethod.GET)
	public String listaAutores (Model model) {
		
		Plan plan = planBusiness.recuperarEstado();
		model.addAttribute("cursos", plan.getCursos());
		
		return "muestraPlanes";
	}
	
	
}
