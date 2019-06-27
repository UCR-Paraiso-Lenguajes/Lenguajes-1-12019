package com.examen_1.b67156.DataTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examen_1.b67156.DataBase.DataBase;
import com.examen_1.b67156.data.CursosData;
import com.examen_1.b67156.domain.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursosDataTest {
	@Autowired
	private CursosData cursoData ;
	List <Curso> cursos;
	

	@Test
	public void cargaCursos_Test() {
		cursoData.cargaCursos ();
		assertNotNull(DataBase.CURSOS);
	}
	/**
	 * Crea nuevo grupo 
	 * pregunta 1
	 */
	@Test
	public void crearCurso_Test() {
		Curso curso = new Curso("Lenguajes", "Lj", 3, 2);
		cursos = cursoData.CrearCurso(curso);
		assertEquals("Lenguajes", cursos.get(6).getNombre());
	}
	
	
}
