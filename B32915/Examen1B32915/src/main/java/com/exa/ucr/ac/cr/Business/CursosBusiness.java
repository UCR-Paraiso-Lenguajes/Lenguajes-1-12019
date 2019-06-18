package com.exa.ucr.ac.cr.Business;

import java.util.Iterator;

import com.exa.ucr.ac.cr.Domain.Curso;

public class CursosBusiness {

	
	public Iterator<Curso> getCourses(){
		
		PlanEstudiosBusiness planEstudios = new PlanEstudiosBusiness();
		
		return planEstudios.plan.getCursos();
	}
	
	public void deleteCourses(String nameCourse) {
		
	}
	
	public void createCourses(Curso course) {
		
	}
	
	public void updateCourses(Curso course) {
		
	}
}
