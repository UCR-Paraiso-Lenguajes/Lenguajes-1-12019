package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Business.CursoBusiness;
import Business.PlanEstudiosBusiness;
import Domain.PlanEstudios;

@Controller
public class PlanEstudiosController {

	@Autowired
	private PlanEstudiosBusiness planBusiness;
	
	@Autowired
	private CursoBusiness cursoBusiness;
	
	@RequestMapping(value = "/plan", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("cursos", 
				cursoBusiness.listarCursosPorPlan(
						planBusiness.getPlan(new PlanEstudios())));
		return "cursos";
	}
	
}
