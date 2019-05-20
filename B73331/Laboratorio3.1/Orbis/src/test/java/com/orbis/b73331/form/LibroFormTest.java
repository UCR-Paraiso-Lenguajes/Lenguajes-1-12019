package com.orbis.b73331.form;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.b73331.domain.Libro;
import com.orbis.b73331.form.LibroForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroFormTest {
	//@Autowired clases externas
	@Test
	public void test() {

		String[] autoresS = {"Hola","Hi","Hello"};
		 
		LibroForm libroForm1 = new LibroForm();
		libroForm1.setId_editorial(1);
		short ano = 2016;
		libroForm1.setAno(ano);
		libroForm1.setId_libro(1);
		float precio = 200;
		libroForm1.setPrecio(precio);
		libroForm1.setTitulo("Lo que el agua de llevo");
		libroForm1.setAutoresS(autoresS);
		
		assertTrue(libroForm1!=null);
	}
}
