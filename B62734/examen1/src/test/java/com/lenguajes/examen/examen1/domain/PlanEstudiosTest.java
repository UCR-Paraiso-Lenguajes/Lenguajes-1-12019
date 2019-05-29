package com.lenguajes.examen.examen1.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanEstudiosTest {

	
	  @Test public void NuevoCursoEnPlan() { 
		  
		PlanEstudios planEstudios=new PlanEstudios("informatica Empresarial");
		Curso curso=new Curso("lenguajes","if-3000",3);
		planEstudios.agregarCurso(curso); 
		
		assertEquals(curso, planEstudios.getCursoPorNombre("lenguajes"));
	  }
	  
	  @Test public void NuevoCursoRequisitos() { 
	Curso cursoInicial=new CursoInicial("introduccion","if-1000",4);
	  
	  CursoConRequisitos cursoRequisitos=new CursoConRequisitos("programacion1",
	  "if-2000", 4);
	  cursoRequisitos.agregarRequisito(cursoInicial); 
	  assertEquals(cursoInicial, cursoRequisitos.getRequisitos().get(0));

	  }
	 
	//test se cae porque es una prueba al error de agregarse a si mismo como requisitos
	  @Test public void cursoRequisitoElMismo() { Curso cursoInicial=new
	  CursoInicial("programacion1", "if-2000",4); CursoConRequisitos
	  cursoRequisitos=new CursoConRequisitos("programacion1", "if-2000", 4);
	  cursoRequisitos.agregarRequisito(cursoInicial); }
	 
	//test se cae porque es una prueba a agregar curso final como requisito
	  @Test public void cursoFinalRequisito() { Curso cursoFinal=new
	  CursoFinal("programacion1", "if-2000",4); CursoConRequisitos
	  cursoRequisitos=new CursoConRequisitos("programacion1", "if-2000", 4);
	  cursoRequisitos.agregarRequisito(cursoFinal); }
	 
	
	  @Test public void planEstudiosCreditos() {
	  
	  PlanEstudios planEstudios=new PlanEstudios("informatica Empresarial"); Curso
	  cursoInicial=new CursoInicial("programacion1", "if-2000",4); Curso curso=new
	  CursoInicial("programacion2", "if-3000",3);
	  
	  planEstudios.agregarCurso(new Curso("lenguajes","if-3000",3));
	  planEstudios.agregarCurso(cursoInicial); planEstudios.agregarCurso(curso);
	  int totalCreditos= planEstudios.totalCreditos();
		
		assertEquals(10,totalCreditos);
		 		 
	  }
	  
	  @Test public void planEstudiosCursos() {
	  
	  PlanEstudios planEstudios=new PlanEstudios("informatica Empresarial");
	  Curso cursoInicial=new CursoInicial("programacion1", "if-2000",4); 
	  Curso curso=new CursoInicial("programacion2", "if-3000",3);
	  
	  planEstudios.agregarCurso(new Curso("lenguajes","if-3000",3));
	  planEstudios.agregarCurso(cursoInicial);
	  planEstudios.agregarCurso(curso);
	  int totalCursos= planEstudios.totalCursosPlan(); 
	  assertEquals(3,totalCursos);

	  }
	 
	  @Test
		public void	planEstudiosCursosRequeridos() 
		{
		  
		  PlanEstudios planEstudios=new PlanEstudios("informatica Empresarial");
		  Curso cursoInicial=new CursoInicial("programacion1", "if-2000",4);
		  Curso curso=new CursoInicial("programacion2", "if-3000",3);
		  CursoConRequisitos cursoConRequisitos=new CursoConRequisitos("SistemasOperativos", "if-4000", 4);
		  
		  planEstudios.agregarCurso(new Curso("lenguajes","if-3000",3)); 
		  cursoConRequisitos.agregarRequisito(curso);
		  cursoConRequisitos.agregarRequisito(cursoInicial);
		  planEstudios.agregarCurso(cursoConRequisitos);
		  planEstudios.listaRequisitos(cursoConRequisitos);

		}
}
