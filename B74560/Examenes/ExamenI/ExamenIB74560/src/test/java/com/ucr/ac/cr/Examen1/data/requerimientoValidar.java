package com.ucr.ac.cr.Examen1.data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

import com.ucr.ac.cr.Examen1.domain.Curso;

public class requerimientoValidar {

	PlanEstudiosData planDao = new PlanEstudiosData();
	Logger logger = Logger.getLogger("MyLog");

	/*NO DEBE PERMITIR LA CREACIÓN DE UN CURSO Y ÉL MISMO COMO REQUISITO.*/
	@Test
	public void crearCursoRequesitoFinal() {
	
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
