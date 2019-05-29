package com.ucr.ac.cr.planDeEstudios.data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import com.ucr.ac.cr.planDeEstudios.domain.Curso;
import com.ucr.ac.cr.planDeEstudios.domain.PlanDeEstudios;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDataTest {

	@Autowired
	CursoData cursoData;
	
		@Test
		public void crearCursoYAsignarTest() 
		{
			List<Curso> cursosInvolucrados = new ArrayList<Curso>();
		
			Curso curso = new Curso();
			curso.setIdCurso(1);
			curso.setCreditos(3);
			curso.setFinalOrInicial(true);
			curso.setNombre("Gestión publica");
			curso.setSiglas("IF4001");;
			cursosInvolucrados.add(curso);
			
			PlanDeEstudios plan = new PlanDeEstudios();
			plan.setCantidadDeCursos(12);
			plan.setCreditosTotales(120);
			plan.setIdPlan(1);
			plan.setNombre("plan administración");
			plan.setCursosInvolucrados(cursosInvolucrados);
			
			
			
			boolean resultado;

			resultado = cursoData.insertarCurso(curso);

			assertTrue(resultado);
			
		}
		
		@Test
		public void cursoRequisitosTest() {
			
			Curso requisito = new Curso();
			requisito.setIdCurso(2);
			requisito.setCreditos(3);
			requisito.setFinalOrInicial(true);
			requisito.setNombre("Teoría organizacional");
			requisito.setSiglas("IF2000");
			
			
			Curso curso = new Curso();
			curso.setIdCurso(1);
			curso.setCreditos(3);
			curso.setFinalOrInicial(true);
			curso.setNombre("Gestión pública");
			curso.setSiglas("IF4101");
			curso.setRequisito(requisito);
		
			boolean resultado;

			resultado = cursoData.insertarCurso(curso);

			assertTrue(resultado);
			
			
		}
		
		
		@Test
		public void validaRequisito() {
			
			Curso requisito = new Curso();
			requisito.setIdCurso(1);
			requisito.setCreditos(3);
			requisito.setFinalOrInicial(true);
			requisito.setNombre("Gestión pública");
			requisito.setSiglas("IF2000");
			
			
			Curso curso = new Curso();
			curso.setIdCurso(1);
			curso.setCreditos(3);
			curso.setFinalOrInicial(true);
			curso.setNombre("Gestión pública");
			curso.setSiglas("IF2000");
			curso.setRequisito(requisito);
		
			boolean resultado;

			resultado = cursoData.insertarCurso(curso);

			assertTrue(resultado);
			
			
		}
		
		@Test
		public void cantidadCreditos() {
			
			
			List<Curso> cursosInvolucrados = new ArrayList<Curso>();
			
			Curso curso = new Curso();
			curso.setIdCurso(1);
			curso.setCreditos(3);
			curso.setFinalOrInicial(true);
			curso.setNombre("Gestión publica");
			curso.setSiglas("IF4001");;
			cursosInvolucrados.add(curso);
			
			PlanDeEstudios plan = new PlanDeEstudios();
			plan.setCantidadDeCursos(12);
			plan.setCreditosTotales(3);
			plan.setIdPlan(1);
			plan.setNombre("plan administración");
			plan.setCursosInvolucrados(cursosInvolucrados);
			
			
			//assertArrayEquals(plan.getCreditosTotales(),curso.getCreditos());
			
			
		}

		

		
		
	}



