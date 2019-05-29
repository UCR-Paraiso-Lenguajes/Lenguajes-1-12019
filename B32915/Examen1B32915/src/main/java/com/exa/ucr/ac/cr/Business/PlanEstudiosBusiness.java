package com.exa.ucr.ac.cr.Business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;

import com.exa.ucr.ac.cr.Domain.Curso;
import com.exa.ucr.ac.cr.Domain.PlanEstudios;

public class PlanEstudiosBusiness {

	@Autowired
	PlanEstudios plan;

	public PlanEstudios planEstudio = recoverState();

	public PlanEstudios recoverState() {

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

		PlanEstudios planInnovacion = new PlanEstudios("Innovaccion", cursosInnovacion);

		return planInnovacion;
	}

	public int numberOfCourses() {

		int courses = 0;
		Iterator<Curso> planPerName = planEstudio.getCursos();

		while (planPerName.hasNext() == true) {

			planPerName.next();

			courses++;

		}

		return courses;
	}

	public int numberOfCreditsByPlan() {

		int credits = 0;
		Iterator<Curso> courses = planEstudio.getCursos();

		while (courses.hasNext() == true) {

			Curso course = (Curso) courses.next();

			credits += course.getCreditos();

		}

		return credits;
	}

	public Iterator<Curso> quantityRequirements(Curso curso) {

		Iterator<Curso> cursosDelPlan = planEstudio.getCursos();

		ArrayList<Curso> listaCursos = Lists.newArrayList((cursosDelPlan));

		ArrayList<Curso> cursosRequeriments = new ArrayList<Curso>();

		ArrayList<Curso> listRequirements = ListOfRequirements(curso,listaCursos, cursosRequeriments,0);

		Iterator<Curso> finalList = listRequirements.iterator();

		return finalList;
	}

	public ArrayList<Curso> ListOfRequirements(Curso curso,ArrayList<Curso> listaCursos,ArrayList<Curso> cursosRequeriments,int count) {

		
		curso = listaCursos.get(count);
		
		
		if (curso.isInicial() == false && count == listaCursos.size()-1) {

			cursosRequeriments.add(curso);
			count++;
		
			return ListOfRequirements(curso, listaCursos, cursosRequeriments,count);

		}else if(curso.isInicial() == true){

			return cursosRequeriments;

		}

		return cursosRequeriments;
	}

	public Iterator<Curso> coursesByPlan() {

		Iterator<Curso> coursesPerName = planEstudio.getCursos();

		return coursesPerName;
	}

	public PlanEstudios getPlan() {

		return plan;
	}

	public void deletePlan(String namePlan) {

	}

	public void createPlan(PlanEstudios plan) {

	}

	public void updatePlan(PlanEstudios plan) {

	}

}
