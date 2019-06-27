package com.ucr.ac.cr.Examen1.data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

import com.ucr.ac.cr.Examen1.data.PlanEstudiosData;
import com.ucr.ac.cr.Examen1.domain.Area;
import com.ucr.ac.cr.Examen1.domain.Curso;

public class PlanEstudiosDataTest {
	
	
	PlanEstudiosData planDao = new PlanEstudiosData();
	Logger logger = Logger.getLogger("MyLog");

	/*Que Recupere el Sistema los datos por defecto*/
	@Test
	public void llenarListaTest() {
	
		planDao.llenarLista();
		int credictos = planDao.credictosTotales;
		int curso = planDao.cursosTotales;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos = planDao.plan.getCursos();
		 
		assertNotNull(cursos);
		logger.info("Credictos totales: " + credictos);
		logger.info("Cursos totales: " + curso);


	}
	
	


	
}
