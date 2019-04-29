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
public class LibroTest {
	//@Autowired clases externas
	@Test
	public void test() {
		Libro libro1 = new Libro();
		libro1.setId_editorial(1);
		short ano = 2016;
		libro1.setAno(ano);
		libro1.setId_libro(1);
		float precio = 200;
		libro1.setPrecio(precio);
		libro1.setTitulo("Lo que el agua de llevo");
		
		Libro libro2 = new Libro(2, "Ants", ano, precio, 2);
		
		assertTrue(libro1!=null);
		assertTrue(libro2!=null);
	}
}
