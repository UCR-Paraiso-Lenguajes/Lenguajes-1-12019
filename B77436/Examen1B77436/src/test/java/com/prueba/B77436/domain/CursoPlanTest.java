package com.prueba.B77436.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prueba.B77436.business.CursoBusiness;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoPlanTest {
	
	@Autowired
	CursoBusiness cursoBusiness;
	
	@Test
	public void crearCursoyPlan() {
		
		Curso curso = new Curso(1, "Introduccion", "IF100", 4);
		Curso curso1 = new Curso(2, "Progra", "IF200", 4);
		ArrayList<Integer> requesitos = new ArrayList<Integer>();
		requesitos.add(curso.getIdCurso());
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(curso);
		cursos.add(curso1);
		PlandeEstudios plan = new PlandeEstudios("Informatica", cursos);
		
		assertNotNull(curso);
		assertNotNull(curso1);
		
		assertNotNull(requesitos);
		assertNotNull(cursos);
		
		assertEquals(curso.getNombre(), "Introduccion");
		assertEquals(curso1.getNombre(), "Progra");
		
		assertEquals(plan.getNombre(), "Informatica");
		Curso cursoplan= plan.getCursos().get(0);
		assertEquals(cursoplan.getNombre(), "Introduccion");
	}
	
	@Test
	public void crearCursoRequisitos() {
		Curso curso = new Curso(1, "Redes I", "IF5100", 4);
		ArrayList<Integer> requisitos = new ArrayList<Integer>();
		requisitos.add(1);
		Curso curso1 = new Curso(2, "Redes II", "IF5200", 4, requisitos);
		
		assertNotNull(curso);
		assertNotNull(curso1);
		
		ArrayList<Integer> cursoConRequisito =curso1.getRequisitos();
		assertNotNull(cursoConRequisito.get(0));
		
	}
	
	@Test
	public void validarRequisito() {
		ArrayList<Integer> requisitos = new ArrayList<Integer>();
		requisitos.add(1);
		Curso curso = new Curso(1, "Lenguajes", "IF4101", 4,requisitos);
		
		assertNotNull(curso);
	}
	
	@Test
	public void cantidadCreditos() {
		Curso curso = new Curso(1,"Algoritmos","IF300",4);
		Curso curso1 = new Curso(2,"SO","IF4100",4);
		Curso curso2 = new Curso(3,"Redes","IF400",5);
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(curso);
		cursos.add(curso1);
		cursos.add(curso2);
		PlandeEstudios plan = new PlandeEstudios("Info", cursos);
		int creditosCarrera=cursoBusiness.cantidadCreditos(cursos);
		assertEquals(13, creditosCarrera);
	}
	
	@Test
	public void cantidadCursosPlan() {
		Curso curso = new Curso(1,"Algoritmos","IF300",4);
		Curso curso1 = new Curso(2,"SO","IF4100",4);
		Curso curso2 = new Curso(3,"Redes","IF400",5);
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(curso);
		cursos.add(curso1);
		cursos.add(curso2);
		PlandeEstudios plan = new PlandeEstudios("Info", cursos);
		int cursosCarrera=cursoBusiness.cantidadCursos(cursos);
		assertEquals(3, cursosCarrera);
	}
	
	@Test
	public void calculaRequesitosdeCurso() {
		Curso curso = new Curso(1,"Algoritmos","IF300",4);
		Curso curso1 = new Curso(2,"SO","IF4100",4);
		ArrayList<Integer> requisitos = new ArrayList<Integer>();
		requisitos.add(2);
		requisitos.add(1);
		Curso curso2 = new Curso(3,"Redes","IF400",5,requisitos);
		ArrayList<Curso> cursosPlan = new ArrayList<Curso>();
		cursosPlan.add(curso);
		cursosPlan.add(curso1);
		cursosPlan.add(curso2);
		PlandeEstudios plan = new PlandeEstudios("Info", cursosPlan);
		Iterator<Curso> calculoRequesito = cursoBusiness.calculaRequesitosCurso(curso2, plan);
		Curso cursoBuscado = calculoRequesito.next();
		assertEquals("SO", cursoBuscado.getNombre());
		Curso cursoBuscado2 = calculoRequesito.next();
		assertEquals("Algoritmos", cursoBuscado2.getNombre());
	}
}
