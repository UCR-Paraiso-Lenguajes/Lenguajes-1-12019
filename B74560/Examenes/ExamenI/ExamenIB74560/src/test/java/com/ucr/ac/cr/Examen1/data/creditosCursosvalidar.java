package com.ucr.ac.cr.Examen1.data;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.ucr.ac.cr.Examen1.domain.Curso;

public class creditosCursosvalidar {
	
	PlanEstudiosData planDao = new PlanEstudiosData();
	Logger logger = Logger.getLogger("MyLog");

	/*EL PLAN DE ESTUDIOS DEBE RETORNAR LA CANTIDAD DE CRÉDITOS CORRECTA EN
	FUNCIÓN DE LOS CURSOS INSERTADOS. 5PTS.
	6. EL PLAN DE ESTUDIOS DEBE RETORNAR LA CANTIDAD DE CURSOS CORRECTA EN FUNCIÓN
	DE LOS CURSOS INSERTADOS.*/
		@Test
		public void credictosCursosCorrectos() {
		
			planDao.llenarLista();
			
			assertNotNull(planDao.plan.getCursos());
			
			Curso cursoNuevo = new Curso("Metodos de Investigacion Cualitativa",
					"Etica", "MICl-1A", 4, 8);
			
			planDao.insertarCurso(cursoNuevo);
			
			int credictos = planDao.credictosTotales;
			int curso = planDao.cursosTotales;
			logger.info("Credictos totales: " + credictos);
			logger.info("Cursos totales: " + curso);

		}

}
