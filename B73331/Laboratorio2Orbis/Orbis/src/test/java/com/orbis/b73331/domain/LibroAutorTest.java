package com.orbis.b73331.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroAutorTest {
	//@Autowired clases externas
	@Test
	public void test() {
		List<Integer>listAutores = new ArrayList<>();
		listAutores.add(1);
		listAutores.add(2);
		listAutores.add(3);
		listAutores.add(1);
		
		LibroAutor libroAutor1 = new LibroAutor(1, listAutores);
		
		LibroAutor libroAutor2 = new LibroAutor();
		libroAutor2.setId_libro(2);
		libroAutor2.setAutores(listAutores);
		
		assertTrue(libroAutor1!=null);
		assertTrue(libroAutor2!=null);
	}
}
