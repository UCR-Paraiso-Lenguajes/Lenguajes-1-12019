package com.orbis.B77436.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Libro_AutorTest {

	
	@Test
	public void probarLibro_autor() {
		List<Integer> listaAutores = new ArrayList<Integer>();
		listaAutores.add(100);
		assertNotNull(listaAutores);
		assertTrue(!listaAutores.isEmpty());
		Libro_Autor libroautor = new Libro_Autor(2, listaAutores);
		
		libroautor.setId_libro(3);
		libroautor.setId_autor(listaAutores);
		libroautor.getId_libro();
		libroautor.getId_autor().get(0);
		assertNotNull(libroautor);
		assertTrue(!libroautor.equals(""));
	}
}
