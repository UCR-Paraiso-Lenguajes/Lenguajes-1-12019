package ucr.ac.cr.planDeEstudios.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ucr.ac.cr.planDeEstudios.business.PlanBusiness;
import ucr.ac.cr.planDeEstudios.domain.Curso;

@Controller
public class PlanController {
	@Autowired
	private PlanBusiness planBusiness;
	/*CREE UNA PANTALLA QUE LISTE TODOS LOS CURSOS DE LA CARRERA DE MANERA VERTICAL Y QUE SE DESPLIEGUEN EN EL CENTRO DE LA PANTALLA
	 * INDEPENDIENTEMENTE DEL TAMAÑO DE LA MISMO UTILIZANDO BOOTSTRAP. DEBEN VISUALIZARSE TODOS LOS ATRIBUTOS DEL CURSO*/
	@RequestMapping(value="/planDeEstudios", method=RequestMethod.GET )
	public String verPlan(Model model) {
		ArrayList<Curso> cursos = planBusiness.traeCursos();
		model.addAttribute("cursos", cursos);
		return "planDeEstudios";
	}
}
