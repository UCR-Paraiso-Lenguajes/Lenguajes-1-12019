package com.ucr.ac.cr.Examen1.data;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.ucr.ac.cr.Examen1.domain.Curso;

public class CursoNuevo {

	PlanEstudiosData planDao = new PlanEstudiosData();
	Logger logger = Logger.getLogger("MyLog");
	
	
	/*CREACIÓN DE UN CURSO Y ASIGNARLO A UN PLAN.*/
	@Test
	public void crearCurso() {
	
		planDao.llenarLista();
		 
		assertNotNull(planDao.plan.getCursos());
		
		Curso cursoNuevo = new Curso("Metodos de Investigacion Cualitativa",
				"Etica", "MICl-1A", 4, 8);
		
		planDao.insertarCurso(cursoNuevo);
		logger.info("Ingresado");

		
	}
}
