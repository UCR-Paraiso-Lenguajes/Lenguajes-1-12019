package com.cr.ac.ucr.programaEstudios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Business.PlanEstudiosBusiness;
import Domain.Curso;
import Domain.PlanEstudios;

public class PlanEstudioBusinessTest {

	@Autowired
	PlanEstudiosBusiness planEstudiosBusiness;
	
	
	@Test
	public void cantidadCreditos() {
		PlanEstudios planEstudios = new PlanEstudios();
		
		Curso curso = new Curso("IF-100", "Introducción Informática", 4, true, false, null);
		ArrayList<Curso> cursosPlan= new ArrayList<>();
		cursosPlan.add(curso);
		PlanEstudios planEstudio = new PlanEstudios("Maestria x", cursosPlan);
		planEstudiosBusiness.getCantidadCreditosTotal(planEstudios);
		
		assertNotNull(cursosPlan);
	}

	@Test
	public void cantidadCursos() {
		PlanEstudios planEstudios = new PlanEstudios();
		
		Curso curso = new Curso("IF-100", "Introducción Informática", 4, true, false, null);
		ArrayList<Curso> cursosPlan= new ArrayList<>();
		cursosPlan.add(curso);
		PlanEstudios planEstudio = new PlanEstudios("Maestria x", cursosPlan);
		planEstudiosBusiness.getCantidadCursosTotal(planEstudios);
		
		assertNotNull(cursosPlan);
	}
	
	@Test
	public void getCursosRequisitos() {
		PlanEstudios planEstudios = new PlanEstudios();
		
		Curso curso = new Curso("IF-100", "Introducción Informática", 4, true, false, null);
		ArrayList<Curso> cursosPlan= new ArrayList<>();
		ArrayList<Curso> cursosReq= new ArrayList<>();
		cursosPlan.add(curso);
		PlanEstudios planEstudio = new PlanEstudios("Maestria x", cursosPlan);
		for (int i = 0; i < planEstudiosBusiness.getPlan(planEstudio).getCursosDelPlan().size(); i++) {
			cursosReq.add((Curso) planEstudiosBusiness.getPlan(planEstudio).getCursosDelPlan().get(i).getCursosRequisito());
		}
		
		assertNotNull(cursosReq);
	}
}
