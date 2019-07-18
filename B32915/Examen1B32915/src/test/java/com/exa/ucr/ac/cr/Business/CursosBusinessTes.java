package com.exa.ucr.ac.cr.Business;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exa.ucr.ac.cr.Domain.Curso;
import com.exa.ucr.ac.cr.Domain.PlanEstudios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursosBusinessTes {
	
	@Test
	public void finalCourseNotRequirement(Curso course) {
		
		Curso courseIngles= new Curso("Ingles", "IP", 3, null, true, false);
		Curso courseInglesII= new Curso("InglesII", "I2", 3, null, true, false);
		
		ArrayList<Curso> coursesRequirements1 = new ArrayList<Curso>();
		
		if(courseIngles.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseIngles);
		}
		
		if(courseInglesII.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseInglesII);
		}
		
		Iterator<Curso> requeriments1 = coursesRequirements1.iterator();
		
		Curso courseInglesIII = new Curso("InglesIII", "I3", 3, requeriments1, false, true);
		
		if(courseInglesIII.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseInglesIII);
		}			
		
		assertNotNull(coursesRequirements1);
	}
	

	@Test
	public void createCourseWithRequirements() {
		
		Curso courseIngles= new Curso("Ingles", "IP", 3, null, true, false);
		Curso courseInglesII= new Curso("InglesII", "I2", 3, null, true, false);
		
		ArrayList<Curso> coursesRequirements1 = new ArrayList<Curso>();
		
		if(courseIngles.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseIngles);
		}
		
		if(courseInglesII.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseInglesII);
		}
		
		Iterator<Curso> requeriments1 = coursesRequirements1.iterator();
		
		Curso courseInglesIII = new Curso("InglesIII", "I3", 3, requeriments1, false, true);		
		
		assertNotNull(courseInglesIII);
		
	}
	 
	@Test
	public void createCourseWithAssignPlan() {
		
		ArrayList<Curso> coursesList = new ArrayList<Curso>();
		Curso courseIngles= new Curso("Ingles", "IP", 3, null, true, false);
		Curso courseInglesII= new Curso("InglesII", "I2", 3, null, true, false);
		
		ArrayList<Curso> coursesRequirements1 = new ArrayList<Curso>();
		
		if(courseIngles.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseIngles);
		}
		
		if(courseInglesII.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseInglesII);
		}
		
		Iterator<Curso> requeriments1 = coursesRequirements1.iterator();
		
		Curso courseInglesIII = new Curso("InglesIII", "I3", 3, requeriments1, false, true);
		
		coursesList.add(courseIngles);
		coursesList.add(courseInglesII);
		coursesList.add(courseInglesIII);
		
		Iterator<Curso> cursosInnovacion = coursesList.iterator();
		PlanEstudios plan = new PlanEstudios("Ingles Conversacional", cursosInnovacion);
		
		assertNotNull(plan);
	}   
	
	@Test
	public void createWithOutBeenRequesite() {
		
		Curso courseIngles= new Curso("Ingles", "IP", 3, null, true, false);
		Curso courseInglesII= new Curso("InglesII", "I2", 3, null, true, false);
		
		ArrayList<Curso> coursesRequirements1 = new ArrayList<Curso>();
		
		if(courseIngles.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseIngles);
		}
		
		if(courseInglesII.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseInglesII);
		}
		
		Iterator<Curso> requeriments1 = coursesRequirements1.iterator();
		
		Curso courseInglesIII = new Curso("InglesIII", "I3", 3, requeriments1, true, false);
		if(courseInglesIII.isEsFinal() == true ) {
			throw new RuntimeException("Los cursos finales no pueden ser requesitos");
		}else {
			coursesRequirements1.add(courseInglesII);
		}
		
		assertNotNull(requeriments1);
		
		/*Debido a la estructura no se puede insertar un requerimiento con el curso que esta en vigencia
		 * Se debe instanciar previamente antes de insertarlo al iterator de Requesitos y posteriormente 
		 * se crea el Curso con su lista de Requerimientos*/
	}
	 
}
