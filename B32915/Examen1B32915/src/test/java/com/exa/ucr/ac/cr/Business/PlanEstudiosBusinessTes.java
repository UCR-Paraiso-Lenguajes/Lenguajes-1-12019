package com.exa.ucr.ac.cr.Business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exa.ucr.ac.cr.Domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanEstudiosBusinessTes {

	
	@Test
	public void creditosPorPlanCreado() {
		PlanEstudiosBusiness planEstudios = new PlanEstudiosBusiness();

		planEstudios.recoverState();

		int expectedValue = 21;
		assertEquals(expectedValue, planEstudios.numberOfCreditsByPlan());
		assertNotNull(planEstudios.numberOfCreditsByPlan());

	}

	@Test
	public void cantidadCursosInsertados() {

		PlanEstudiosBusiness planEstudios = new PlanEstudiosBusiness();

		planEstudios.recoverState();

		int numberOfCourses = 6;
		assertEquals(numberOfCourses, planEstudios.numberOfCourses());
		assertNotNull(planEstudios.numberOfCourses());

	}

	@Test
	public void cantidadCursosRequirements() {

		PlanEstudiosBusiness planEstudios = new PlanEstudiosBusiness();

		ArrayList<Curso> coursesList = new ArrayList<Curso>();
		ArrayList<Curso> coursesRequirements1 = new ArrayList<Curso>();
		ArrayList<Curso> coursesRequirements2 = new ArrayList<Curso>();
		ArrayList<Curso> coursesRequirements3 = new ArrayList<Curso>();

		Curso TeoriaOrganizacional = new Curso("Teoria Organizacional", "TO3", 3, null, false, true);

		coursesRequirements1.add(TeoriaOrganizacional);
		Iterator<Curso> requeriments1 = coursesRequirements1.iterator();

		Curso GestionPublica = new Curso("Gestion Publica", "GP", 3, requeriments1, false, false);
		Curso GestionSocial = new Curso("Gestion Social", "GS", 3, requeriments1, false, false);
		Curso GestionProyectos = new Curso("Gestion de Proyectos", "GDP", 4, requeriments1, false, false);

		coursesRequirements2.add(GestionPublica);
		coursesRequirements2.add(GestionSocial);
		coursesRequirements2.add(GestionProyectos);
		Iterator<Curso> requeriments2 = coursesRequirements2.iterator();

		Curso GestionEstrategica = new Curso("Gestion Estrategica", "GE", 4, requeriments2, false, false);

		coursesRequirements3.add(GestionEstrategica);
		Iterator<Curso> requeriments3 = coursesRequirements3.iterator();

		Curso PlanNegocios = new Curso("Plan de Negocios", "PN", 4, requeriments3, false, true);

		coursesList.add(TeoriaOrganizacional);
		coursesList.add(GestionPublica);
		coursesList.add(GestionSocial);
		coursesList.add(GestionProyectos);
		coursesList.add(GestionEstrategica);
		coursesList.add(PlanNegocios);

		Iterator<Curso> cursosInnovacion = coursesList.iterator();
		Iterator<Curso> cursosRequerimientos = planEstudios.quantityRequirements(PlanNegocios);
		
		assertEquals(cursosInnovacion, cursosRequerimientos);
		assertNotNull(planEstudios.quantityRequirements(PlanNegocios));
	}

}
