package com.ucr.ac.cr.Examen1.data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.Test;

import com.ucr.ac.cr.Examen1.domain.Area;
import com.ucr.ac.cr.Examen1.domain.Curso;

public class Buscar {
	
	PlanEstudiosData planDao = new PlanEstudiosData();
	Logger logger = Logger.getLogger("MyLog");

	/*EL PLAN DE ESTUDIOS PUEDEN CALCULAR LOS CURSOS REQUERIDOS PARA UNO
ESPECÍFICO.*/
	@Test
	public void Buscar() {
	
		planDao.llenarLista();
		ArrayList<Curso> returnLista = new ArrayList<Curso>();
		Curso seminario = new Curso("Seminario de Investigacion", Area.Analisis.getNombreArea(), "SI-5A", 3, 5);
		returnLista = planDao.buscarRequisitosExistente(seminario);
		assertNotNull(returnLista);
		logger.info("Requisitos del Curso: " + seminario.getSiglaCurso());
		for (int i = 0; i < returnLista.size(); i++) {
			logger.info(returnLista.get(i).getNombreCurso() + ", en el ciclo: " +returnLista.get(i).getCiclo());
		}

	}

}
