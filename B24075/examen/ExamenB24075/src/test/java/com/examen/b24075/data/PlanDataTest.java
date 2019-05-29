package com.examen.b24075.data;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.examen.b24075.domain.Curso;
import com.examen.b24075.domain.Plan;

public class PlanDataTest {
	
	@Autowired
	PlanData plandata;
	
	@Autowired
	
	CursoData cd;

	@Test
	public void cursosPorPlan() {
		
		Plan p = new Plan("informatica");
		Curso c = new Curso("info aplicada ","21f",3,new ArrayList<Curso>(),p);
		
		plandata.guardarPlan(p);
		
		
	cd.guardarCurso(c);
	
	
	assertNotNull(plandata.cursosPorPlan("informatica"));
	
	}

	

//	@Test
//	public void creditosPorPlan(String nombrePlan) {
//		
//		Plan p = new Plan("informatica");
//		Curso c = new Curso("info aplicada ","21f",3,new ArrayList<Curso>(),p);
//		
//		plandata.guardarPlan(p);
//		
//		
//	cd.guardarCurso(c);
//	
//	
//	plandata.creditosPorPlan("informatica");
//		
//	}
}
