package com.ucr.ac.cr.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ucr.ac.cr.data.DatosEnMemoria;
import com.ucr.ac.cr.domain.Curso;

@Controller
public class MostarPlanController {
	
	DatosEnMemoria datos = new DatosEnMemoria();
	
	@RequestMapping(value="/planEstudio", method=RequestMethod.GET )
	public String iniciar(Model model) {
		datos.datos();
		ArrayList<Curso> cursos = datos.cursos;
		model.addAttribute("cursos", cursos);
		return "planEstudio";
	}

}

