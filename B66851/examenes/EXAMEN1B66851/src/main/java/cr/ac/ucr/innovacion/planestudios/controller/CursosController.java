package cr.ac.ucr.innovacion.planestudios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.innovacion.planestudios.business.PlanEstudiosBusiness;

@Controller
public class CursosController {

	
	@Autowired
	private PlanEstudiosBusiness planEstudiosBusiness;

	 @RequestMapping(value="/cursos", method=RequestMethod.GET )
	 //public String cursos() {
	 public String cursos(Model model) {
	  model.addAttribute("cursos", planEstudiosBusiness.obtenerCursos());
	  return "cursos";
	 }
	




}
