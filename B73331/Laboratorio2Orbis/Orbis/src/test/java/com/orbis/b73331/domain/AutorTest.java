package com.orbis.b73331.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutorTest {
	//@Autowired //clases externas
	Autor autor1, autor2;
	@Test
	public void test() {
		autor1 = new Autor();
		autor1.setNombre_autor("Zacarias");
		autor1.setApellidos_autor("Retono Quesada");
		autor1.setId_autor(1);
		
		autor2 = new Autor(2, "Mario", "Sonoro");
		
		assertTrue(autor1!=null);
		assertTrue(autor2!=null);
	}
}
