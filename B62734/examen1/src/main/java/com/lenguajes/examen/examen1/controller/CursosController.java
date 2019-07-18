package com.lenguajes.examen.examen1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lenguajes.examen.examen1.data.PlanEstudiosData;
import com.lenguajes.examen.examen1.domain.Curso;
import com.lenguajes.examen.examen1.domain.CursoConRequisitos;
import com.lenguajes.examen.examen1.domain.CursoInicial;

@Controller
public class CursosController {
	
	PlanEstudiosData planEstudios=new PlanEstudiosData();
	
	@RequestMapping(value="/listacursos", method=RequestMethod.GET )
	public String editarAutor(Model model)
	{		
		
		model.addAttribute("cursos", planEstudios.mantenerEstado());
		
		return "lista_cursos";
	}	
	
	
}
