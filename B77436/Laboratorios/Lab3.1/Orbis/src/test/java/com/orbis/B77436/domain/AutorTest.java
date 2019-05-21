package com.orbis.B77436.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorTest {
	
	@Test
	public void probarAutor() {
		Autor autor = new Autor();
		autor.setId_autor(100);
		autor.setNombre_autor("Emmanuel");
		autor.setApellidos_autor("Solano");
		autor.getId_autor();
		autor.getNombre_autor();
		autor.getApellidos_autor();
		assertNotNull(autor);
		assertTrue(!autor.equals(""));
	}

}
