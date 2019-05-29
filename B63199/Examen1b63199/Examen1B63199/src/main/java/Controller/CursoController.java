package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Business.CursoBusiness;
import Business.PlanEstudiosBusiness;

@Controller
public class CursoController {
	@Autowired
	private CursoBusiness cursoBusiness;
	@Autowired
	private PlanEstudiosBusiness planBusiness;
	
	
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("cursos", cursoBusiness.listarCursosPorPlan());
		model.addAttribute("cantidadCursos", cursoBusiness.listarCursosPorPlan().size());
		return "cursos";
	}
	
	
}

