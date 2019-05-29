package com.cr.ac.ucr.programaEstudios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Business.CursoBusiness;
import Domain.Curso;
import Domain.PlanEstudios;

@SpringBootTest
public class CursoBusinessTest {

	@Autowired
	CursoBusiness cursoBusiness;
	
	@Test
	private void insertarCurso() {
		PlanEstudios planEstudios = new PlanEstudios();
		Curso curso = new Curso("IF-100", "Introducción Informática", 4, true, false, null);
		cursoBusiness.insertarCurso( curso, planEstudios);
		assert(cursoBusiness.listarCursosPorPlan(planEstudios)!=null);
	}
	
	@Test
	private void insertarCursoRequisitos() {
		PlanEstudios planEstudios = new PlanEstudios();
		ArrayList<Curso> requisitos=new ArrayList<>();
		requisitos.add(new Curso("Ing_sof", "Ingeniería", 10, false, true, null));
		requisitos.add(new Curso("Herb-11", "Herbolaria", 1, false, true, null));
		
		Curso curso = new Curso("IF-100", "Introducción Informática", 4, true, false, requisitos);
		cursoBusiness.insertarCurso( curso, planEstudios);
		assert(cursoBusiness.listarCursosPorPlan(planEstudios)!=null);
	}
	
	

}
