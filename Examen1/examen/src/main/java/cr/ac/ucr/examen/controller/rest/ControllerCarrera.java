package cr.ac.ucr.examen.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.examen.business.CarreraBusiness;
import cr.ac.ucr.examen.domain.Curso;

@Controller
public class ControllerCarrera {

	@Autowired
	CarreraBusiness carreraBusiness; 

 	@RequestMapping(value = "/listarCursos", method = RequestMethod.GET)
	public String listaAutores (Model model) {

 		List<Curso> cursos = carreraBusiness.estadoInicial();
		model.addAttribute("cursos", cursos);

 		return "verCursos";
	}
	
	
}
