package com.ucr.ac.cr.Examen1.data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

import com.ucr.ac.cr.Examen1.domain.Curso;

public class cursoRequerimientos {

	PlanEstudiosData planDao = new PlanEstudiosData();
	Logger logger = Logger.getLogger("MyLog");
	
	/*CREACIÓN DE UN CURSO CON REQUISITOS.

	 EL CURSO FINAL NO PUEDE SER REQUISITO DE NINGÚN OTRO CURSO.*/

	@Test
	public void crearCursoRequerimientos() {
	
		planDao.llenarLista();
		
		Curso cursoNuevo = new Curso("Metodos de Investigacion Cualitativa",
				"Etica", "MICl-1A", 4, 8);
		
		ArrayList<Curso> returnLista = new ArrayList<Curso>();
		returnLista = planDao.insertarCursoRequisitos(cursoNuevo);
		assertNotNull(returnLista);
		logger.info("Requisitos del Ingresado");
		for (int i = 0; i < returnLista.size(); i++) {
			logger.info(returnLista.get(i).getNombreCurso() + ", en el ciclo: " +returnLista.get(i).getCiclo());
		}

	}
	

}
