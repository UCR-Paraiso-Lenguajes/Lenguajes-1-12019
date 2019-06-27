package com.examen1.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examen1.domain.Curso;


@Service
public class cursoBusiness {
	
	public List<Curso> listaCursos;
	
	public cursoBusiness() {
		
		listaCursos = new ArrayList<>();
		
		Curso curso_1 = new Curso("Teoría Organizacional", "TO1", 3, "");
		Curso curso_2 = new Curso("Metodos de investigacion cualitativa", "MIC", 4, "");
		Curso curso_3 = new Curso("Economia aplicada a la gestion", "EAG", 3, "");
		Curso curso_4 = new Curso("Taller de habilidades gerenciales", "THG", 1, "");
		Curso curso_5 = new Curso("Bases legales para la gestion", "BLG", 4, "");
		Curso curso_6 = new Curso("Economia aplicada a la gestion II", "EAGII", 3, "");
		Curso curso_7 = new Curso("Gestion publica", "GP", 1, "");
		Curso curso_8 = new Curso("Gestion Social", "GS", 4, "");
		Curso curso_9 = new Curso("Gestion de Proyectos", "GP", 3, "");

		listaCursos.add(curso_1);
		listaCursos.add(curso_2);
		listaCursos.add(curso_3);
		listaCursos.add(curso_4);
		listaCursos.add(curso_5);
		listaCursos.add(curso_6);
		listaCursos.add(curso_7);
		listaCursos.add(curso_8);
		listaCursos.add(curso_9);
		
	}
	
	public List<Curso> retornaLista(){
		
		return listaCursos;
	}

}