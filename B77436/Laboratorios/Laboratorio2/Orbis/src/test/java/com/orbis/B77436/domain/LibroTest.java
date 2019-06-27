package com.orbis.B77436.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroTest {
	
	@Test
	public void probarAutor() {
		Libro libro = new Libro();
		libro.setId_editorial(2);
		libro.setId_libro(18);
		libro.setTitulo("EndGame");
		libro.setAno((short) 2019);
		libro.setPrecio(2000);
		
		libro.getId_editorial();
		libro.getId_libro();
		libro.getTitulo();
		libro.getAno();
		libro.getPrecio();
		assertNotNull(libro);
		assertTrue(!libro.equals(""));
	}

}
