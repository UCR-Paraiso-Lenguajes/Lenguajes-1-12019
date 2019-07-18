package com.prueba.B77436.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prueba.B77436.domain.Carrera;
import com.prueba.B77436.domain.Ciclo;
import com.prueba.B77436.domain.Curso;
import com.prueba.B77436.domain.PlandeEstudios;

@Controller
public class PlanEstudiosController {
	public ArrayList<Curso> cursosPlan;
	
	@RequestMapping(value="/PlanEstudios", method=RequestMethod.GET )
	public String iniciar(Model model) {
		PlandeEstudios plan = cargarEstadoPlandeEstudio();
		ArrayList<Ciclo> cursos = plan.getCiclos();
		ArrayList<Curso> ciclo1=cursos.get(0).getCursos();
		ArrayList<Curso> ciclo2=cursos.get(1).getCursos();
		ArrayList<Curso> ciclo3=cursos.get(2).getCursos();
		ArrayList<Curso> ciclo4=cursos.get(3).getCursos();
		ArrayList<Curso> ciclo5=cursos.get(4).getCursos();
		ArrayList<Curso> ciclo6=cursos.get(5).getCursos();
		model.addAttribute("ciclo", ciclo1);
		model.addAttribute("ciclo2", ciclo2);
		model.addAttribute("ciclo3", ciclo3);
		model.addAttribute("ciclo4", ciclo4);
		model.addAttribute("ciclo5", ciclo5);
		model.addAttribute("ciclo6", ciclo6);
		return "PlanEstudios";
	}
	
	
	
	public PlandeEstudios cargarEstadoPlandeEstudio() {
		//ciclo V cursos
		Curso curso1 = new Curso(1,"Teoria Organizacional", "TO", 3);
		Curso curso2 = new Curso(2,"Metodos de investigacion cualitativa", "MI", 4);
		Curso curso3 = new Curso(3,"Metodos de investigacion cualitativa", "MI", 3);
		Curso curso4 = new Curso(4,"Economia aplicada a la Gestion", "ECG", 4);
		Curso curso5 = new Curso(5,"Taller de habilidades gerenciales", "THG", 2);
		
		ArrayList<Curso> cicloV = new ArrayList<Curso>();
		cicloV.add(curso1);
		cicloV.add(curso2);
		cicloV.add(curso3);
		cicloV.add(curso4);
		cicloV.add(curso5);
		////////////////--------------
		//ciclo VI
		ArrayList<Integer> requisitosCurso6 = new ArrayList<Integer>();
		requisitosCurso6.add(2);
		requisitosCurso6.add(3);
		requisitosCurso6.add(4);
		Curso curso6 = new Curso(6,"Bases legales para la gestion", "BLG", 5, requisitosCurso6);
		ArrayList<Integer> requisitosCurso7 = new ArrayList<Integer>();
		requisitosCurso7.add(2);
		requisitosCurso7.add(3);
		requisitosCurso7.add(4);
		Curso curso7 = new Curso(7,"Economia aplicada a la Gestion B", "ECGII", 4, requisitosCurso7);
		ArrayList<Integer> requisitosCurso8 = new ArrayList<Integer>();
		requisitosCurso8.add(5);
		Curso curso8 = new Curso(8,"Taller de habilidades gerenciales II", "THG II", 2,requisitosCurso8);
		ArrayList<Curso> cicloVI = new ArrayList<Curso>();
		cicloVI.add(curso6);
		cicloVI.add(curso7);
		cicloVI.add(curso8);
		////////////////77
		//ciclo VII
		ArrayList<Integer> requisitosCurso9 = new ArrayList<Integer>();
		requisitosCurso9.add(1);
		Curso curso9 = new Curso(9,"Gestion Pública", "GP", 3, requisitosCurso9);
		ArrayList<Integer> requisitosCurso10 = new ArrayList<Integer>();
		requisitosCurso10.add(1);
		Curso curso10 = new Curso(10,"Gestion Social", "GS", 3, requisitosCurso10);
		ArrayList<Integer> requisitosCurso11 = new ArrayList<Integer>();
		requisitosCurso11.add(1);
		Curso curso11 = new Curso(11,"Gestion de proyectos", "GP", 4, requisitosCurso11);
		ArrayList<Curso> cicloVII = new ArrayList<Curso>();
		cicloVII.add(curso9);
		cicloVII.add(curso10);
		cicloVII.add(curso11);
		///////////////////7
		//ciclo VIII
		ArrayList<Integer> requisitosCurso12 = new ArrayList<Integer>();
		requisitosCurso12.add(11);
		requisitosCurso12.add(10);
		requisitosCurso12.add(9);
		requisitosCurso12.add(1);
		Curso curso12 = new Curso(12,"Gestion Estrategica", "GE", 4, requisitosCurso12);
		ArrayList<Integer> requisitosCurso13 = new ArrayList<Integer>();
		requisitosCurso13.add(8);
		requisitosCurso13.add(5);
		Curso curso13 = new Curso(13,"Taller de habilidades gerenciales III", "THG III", 2,requisitosCurso13);
		ArrayList<Curso> cicloVIII = new ArrayList<Curso>();
		cicloVIII.add(curso12);
		cicloVIII.add(curso13);
		////////
		//ciclo IX
		ArrayList<Integer> requisitosCurso14 = new ArrayList<Integer>();
		requisitosCurso14.add(12);
		requisitosCurso14.add(9);
		requisitosCurso14.add(1);
		Curso curso14 = new Curso(14,"Plan de negocios", "PN", 4,requisitosCurso14);
		ArrayList<Integer> requisitosCurso15 = new ArrayList<Integer>();
		requisitosCurso15.add(6);
		requisitosCurso15.add(2);
		Curso curso15 = new Curso(15,"Seminario de Investigación", "Semi", 3,requisitosCurso15);
		Curso curso16 = new Curso(16,"Etica para la gestion", "Et", 2);
		ArrayList<Curso> cicloIX = new ArrayList<Curso>();
		cicloIX.add(curso14);
		cicloIX.add(curso15);
		cicloIX.add(curso16);
		//ciclo  X
		ArrayList<Integer> requisitosCurso17 = new ArrayList<Integer>();
		requisitosCurso17.add(15);
		requisitosCurso17.add(6);
		requisitosCurso17.add(2);
		Curso curso17 = new Curso(17,"Seminario de Investigación II", "Semi II", 4,requisitosCurso17);
		ArrayList<Integer> requisitosCurso18 = new ArrayList<Integer>();
		requisitosCurso18.add(16);
		Curso curso18 = new Curso(18,"Desarrollo y responsabilidad social", "DRS", 3,requisitosCurso18);
		ArrayList<Curso> cicloX = new ArrayList<Curso>();
		cicloX.add(curso17);
		cicloX.add(curso18);
		
		cursosPlan= new ArrayList<Curso>();
		cursosPlan.add(curso1);
		//cursosPlan.add(null);
		cursosPlan.add(curso9);
		cursosPlan.add(curso12);
		cursosPlan.add(curso14);
		//cursosPlan.add(null);
		cursosPlan.add(curso17);
		cursosPlan.add(curso2);
		//cursosPlan.add(null);
		cursosPlan.add(curso10);
		//cursosPlan.add(null);
		cursosPlan.add(curso15);
		cursosPlan.add(curso18);
		cursosPlan.add(curso3);
		cursosPlan.add(curso6);
		cursosPlan.add(curso11);
		cursosPlan.add(curso16);
		cursosPlan.add(curso4);
		cursosPlan.add(curso7);
		cursosPlan.add(curso13);
		cursosPlan.add(curso5);
		cursosPlan.add(curso8);
		
		Ciclo ciclo1 = new Ciclo("Ciclo V", cicloV, "Innovación");
		Ciclo ciclo2 = new Ciclo("Ciclo VI", cicloVI, "Innovación");
		Ciclo ciclo3 = new Ciclo("Ciclo VII", cicloVII, "Innovación");
		Ciclo ciclo4 = new Ciclo("Ciclo VIII", cicloVIII, "Innovación");
		Ciclo ciclo5 = new Ciclo("Ciclo IX", cicloIX, "Innovación");
		Ciclo ciclo6 = new Ciclo("Ciclo X", cicloX, "Innovación");
		ArrayList<Ciclo> ciclosPlanEstudios = new ArrayList<Ciclo>();
		ciclosPlanEstudios.add(ciclo1);
		ciclosPlanEstudios.add(ciclo2);
		ciclosPlanEstudios.add(ciclo3);
		ciclosPlanEstudios.add(ciclo4);
		ciclosPlanEstudios.add(ciclo5);
		ciclosPlanEstudios.add(ciclo6);
		PlandeEstudios plan = new PlandeEstudios("Innovacion", cursosPlan,ciclosPlanEstudios);
		
		return plan;
		//Carrera carrera = new Carrera(1, "Innovación", plan);
	}
}
