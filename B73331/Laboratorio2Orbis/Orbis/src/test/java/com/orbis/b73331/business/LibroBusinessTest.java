package com.orbis.b73331.business;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.b73331.data.LibroData;
import com.orbis.b73331.domain.Libro;
import com.orbis.b73331.domain.LibroAutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroBusinessTest {
	//@Autowired clases externas
	@Autowired //clases externas
	LibroBusiness libroBusiness;
	@Test
	public void testBuscarPorIdEditorial() {
		Iterator<Libro> libro = libroBusiness.buscarPorIdEditorial(2);
		assertTrue(libro!=null);
	}
	@Test
	public void testGuardarLibroAutor() {
		List<Integer>listAutores = new ArrayList<>();
		listAutores.add(1);
		listAutores.add(2);
		listAutores.add(3);
		listAutores.add(1);
		
		
		
		Libro libro1 = new Libro();
		libro1.setId_editorial(1);
		short ano = 2016;
		libro1.setAno(ano);
		libro1.setId_libro(60);
		float precio = 200;
		libro1.setPrecio(precio);
		libro1.setTitulo("Lo que el agua de llevo");
		
		LibroAutor libroAutor1 = new LibroAutor(libro1.getId_libro(), listAutores);
		
		
		libroBusiness.guardarLibroAutor(libro1, libroAutor1);
		//No puedo usar assert ya que guardarLibroAutor(libro1, libroAutor1) es void 
		//assertTrue(libro!=null);
	}
}
