package com.examen1.plan.estudios.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoTest {

	@Test
	public void cursoTest() {
		Curso logica = new Curso("IF-1001", "Logica", 2);
		Curso intro = new Curso("IF-1000", "Introduccion", 4);
		PlanDeEstudios info = new PlanDeEstudios("Informatica");
		info.agregarCurso(1, logica);
		info.agregarCurso(1, intro);
		assertTrue(info.obtenerTotalCursosDelPlan() == 2);
		assertTrue(info.obtenerTotalCreditosDelPlan() == 6);
		info.agregarNuevoCiclo();
		info.agregarCurso(2, new Curso("IF-2000", "Programacion", 4));
		info.agregarCurso(2, new Curso("EG-1003", "Teatro", 3));
		assertTrue(info.obtenerTotalCreditosDelPlan() == 13);
		info.agregarRequisitoCurso(2, "IF-2000", "IF-1000");
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->{
			info.agregarRequisitoCurso(2, "EG-1003", "EG-1003");
		});
		
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->{
			info.agregarRequisitoCurso(2, "EG-1003", "EG-1000");
		});
		
	}
}
