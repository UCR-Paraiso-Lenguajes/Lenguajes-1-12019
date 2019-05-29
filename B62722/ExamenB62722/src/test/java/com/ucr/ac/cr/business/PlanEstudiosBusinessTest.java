package com.ucr.ac.cr.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ucr.ac.cr.domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanEstudiosBusinessTest {

	@Autowired
	private PlanEstudiosBusiness planEstudiosBusiness;
	
	@Test
	public void añadirCursoTest() {
		Curso curso = new Curso("Administracion I", "A1","VI", 2);
		planEstudiosBusiness.añadirCurso(curso);
		assertTrue(planEstudiosBusiness.mostrarPlanEstudios().contains(curso));
	}

	@Test
	public void añadirCursoConRequisitoTest() {
		Curso curso1 = new Curso("Administracion I", "A1", "VI",2);
		Curso curso2 = new Curso("Administracion II", "A2","VII", 2);
		List<Curso> requisitos = new ArrayList<Curso>();
		requisitos.add(curso1);
		assertTrue(planEstudiosBusiness.añadirCursoConRequisito(curso2, requisitos));
	}

	@Test
	public void añadirCursoConRequisitoTest2() {
		Curso curso1 = new Curso("Administracion I", "A1","VI", 2);
		Curso curso2 = new Curso("Administracion I", "A1","VI", 2);
		List<Curso> requisitos = new ArrayList<Curso>();
		requisitos.add(curso1);
		assertFalse(planEstudiosBusiness.añadirCursoConRequisito(curso2, requisitos));
	}
	
	@Test
	public void añadirCursoConRequisitoTest3() {
		Curso curso1 = new Curso("Administracion I", "A1","VI", 2);
		Curso curso2 = new Curso("Practica Supervisada", "PS","X", 6);
		List<Curso> requisitos = new ArrayList<Curso>();
		requisitos.add(curso2);
		assertFalse(planEstudiosBusiness.añadirCursoConRequisito(curso1, requisitos));
	}

	@Test
	public void mostrarCantidadCreditosTest() {
		Curso curso1 = new Curso("Lenguajes", "LG", "VII",4);
		Curso curso2 = new Curso("Bases de datos", "BD","VIII", 4);
		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		assertEquals(8, planEstudiosBusiness.mostrarCantidadCreditos(cursos));
	}

	@Test
	public void mostrarCantidadCursosTest() {
		Curso curso1 = new Curso("Lenguajes", "LG", "VII",4);
		Curso curso2 = new Curso("Bases de datos", "BD","VIII", 4);
		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		assertEquals(2, planEstudiosBusiness.mostrarCantidadCursos(cursos));
	}
	
	@Test
	public void calcularCursosRequeridosTest() {
		Curso curso1 = new Curso("Lenguajes", "LG", "VII",4);
		Curso curso2 = new Curso("Bases de datos", "BD","VIII", 4); 
		Curso curso3 = new Curso("Administracion I", "A1","IX", 2);
		Curso curso4 = new Curso("Administracion II", "A2", "VI",2);
		
		List<Curso> requisitos = new ArrayList<>();
		requisitos.add(curso1);
		requisitos.add(curso2);
		requisitos.add(curso3);
		
		curso4.setCursosRequisito(requisitos);
		
		assertEquals(3, planEstudiosBusiness.calcularCursosRequeridos(curso4));
	}

}
