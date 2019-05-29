package com.examen1b53953.data_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.examen1b53953.business.CursoBusiness;
import com.examen1b53953.business.PlanBusiness;
import com.examen1b53953.domain.Curso;
import com.examen1b53953.domain.PlanDeEstudio;


public class DataTest {

	
	@Autowired
	CursoBusiness cursoBusiness;
	PlanBusiness planBusiness;
	Curso curso;
	
	@Test
	public void ingresarCursoEnPlan() {
		
		Curso curso = new Curso(2," Introduccion a la informatica", "IF-5001", 4);
		planBusiness.agregarCurso(curso);
		
		assertTrue(planBusiness.listarPlanes().contains(curso));
		
	}
	
	@Test
	public void creacionCursoConRequisitos() {
		Curso curso = new Curso(2," Introduccion a la informatica", "IF-5001", 4);
		ArrayList<Curso> cursosRequisitos = new ArrayList<>();
		cursosRequisitos.add(curso);
		Curso curso2 = new Curso(6, "Programacion I", "IF-5003", 4, cursosRequisitos);
		Curso curso3 = new Curso(6, "Programacion I", "IF-5003", 4);
		
		assertEquals(curso2, cursoBusiness.agregarRequisitoAlCurso(curso3, cursosRequisitos));
	}

	
	@Test
	public void creacionCursoMismoReq() {
		Curso curso = new Curso(2," Introduccion a la informatica", "IF-5001", 4);
		ArrayList<Curso> cursosRequisitos = new ArrayList<>();
		cursosRequisitos.add(curso);
		Curso curso2 = new Curso(6, "Programacion I", "IF-5003", 4, cursosRequisitos);
		Curso curso3 = new Curso(6, "Programacion I", "IF-5003", 4);
		
		assertFalse(cursoBusiness.agregarRequisito(curso3, curso3));
	}
	
	
	@Test
	public void numeroCorrectoCursos() {
		Curso curso = new Curso(2," Introduccion a la informatica", "IF-5001", 4);
		planBusiness.agregarCurso(curso);
		PlanDeEstudio plan = new PlanDeEstudio();
		
		assertEquals(2, planBusiness.calcularCursosPlan(plan));
		
	}
	
}
