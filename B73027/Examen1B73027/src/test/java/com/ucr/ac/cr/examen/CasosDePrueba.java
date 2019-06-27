package com.ucr.ac.cr.examen;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ucr.ac.cr.business.PlanDeEstudiosBusiness;
import com.ucr.ac.cr.data.DatosEnMemoria;
import com.ucr.ac.cr.domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CasosDePrueba {

	PlanDeEstudiosBusiness planDeEstudiosBusiness = new PlanDeEstudiosBusiness ();
	
	DatosEnMemoria datos = new DatosEnMemoria();
	
	

	
	//1.CREACIÓN DE UN CURSO Y ASIGNARLO A UN PLAN.
	@Test
	public void crearCurso()
	{
	
	ArrayList<String> requeridos = new ArrayList<String>();
		requeridos.add("IF-5101");
		

		Curso curso = new Curso(5, "Introduccion II", "IF-5102", 6, requeridos, 1);	
		
		planDeEstudiosBusiness.insertarCursos(curso);
	
	assertNotNull(curso);
	
	
	}

	
	
	//2. CREACIÓN DE UN CURSO CON REQUISITOS.
	@Test
	public void crearCursoRequisitos()
	{
		
		ArrayList<String> requeridos = new ArrayList<String>();
		requeridos.add("IF-5000");
		

		Curso curso = new Curso(5, "Introduccion", "IF-5100", 6, requeridos, 1);	
		
		planDeEstudiosBusiness.insertarCursos(curso);
	
		assertNotNull(curso);
		
	}
	
	
	//3. NO DEBE PERMITIR LA CREACIÓN DE UN CURSO Y ÉL MISMO COMO REQUISITO.
	@Test
	public void crearCursoConMismo()
	{
		
		ArrayList<String> requeridos = new ArrayList<String>();
		requeridos.add("IF-5000");
		

		Curso curso = new Curso(5, "Introduccion", "IF-5000", 6, requeridos, 1);	
		
		planDeEstudiosBusiness.insertarCursos(curso);
	
		assertNotNull(curso);
	
	}
	
	//4. EL CURSO FINAL NO PUEDE SER REQUISITO DE NINGÚN OTRO CURSO.
	@Test
	public void cursoFinal()
	{
		
		System.out.println("--------------------------");
		planDeEstudiosBusiness.cursoFinal(1);
		System.out.println("estado del ciclo: "+planDeEstudiosBusiness.cursoFinal(6));
		
	
	}
	
	

	//5. EL PLAN DE ESTUDIOS DEBE RETORNAR LA CANTIDAD DE CRÉDITOS CORRECTA EN FUNCIÓN DE LOS CURSOS INSERTADOS.
	
	@Test
	public void cantidadDeCreditos()
	{
		
		System.out.println("---------------------------------------");
		datos.datos();
		int total;
		total = planDeEstudiosBusiness.totalCreditos(datos.plan);
		System.out.println("Total de creditos: "+total);
	
	}
	
	
	//6. EL PLAN DE ESTUDIOS DEBE RETORNAR LA CANTIDAD DE CURSOS CORRECTA EN FUNCIÓN DE LOS CURSOS INSERTADOS.
	
	@Test
	public void cantidadDeCursos()
	{
		
		System.out.println("---------------------------------------");
		datos.datos();
		int total;
		total = planDeEstudiosBusiness.numersoDeCursos(datos.plan);
		System.out.println("Total de cursos: "+total);
		
	
	}
	
	
	
	//7. EL PLAN DE ESTUDIOS PUEDEN CALCULAR LOS CURSOS REQUERIDOS PARA UNO ESPECÍFICO.
	@Test
	public void cursosRequeridos()
	{
		
		
		datos.datos();
		String total;
		total = planDeEstudiosBusiness.cursosNecesarios("BaLe-2");
		System.out.println("Total de requerimientos: "+total);
		
		
		
	
	}

	

}
