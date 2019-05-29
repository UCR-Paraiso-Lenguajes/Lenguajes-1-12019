package com.orbis.B77436.business;

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

import com.orbis.B77436.domain.Editorial;
import com.orbis.B77436.domain.Libro;
import com.orbis.B77436.domain.Libro_Autor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroBusinessTest {
	
	@Autowired
	private LibroBusiness libroBusiness;

	@Test
	public void buscar() {
		Iterator<Libro> buscaLibro = libroBusiness.buscarId(1);
		assertNotNull(buscaLibro);
		assertTrue(!buscaLibro.equals(""));
	}
	
	@Test
	public void save() {
		Libro libro = new Libro();
		libro.setId_editorial(2);
		libro.setId_libro(1);
		libro.setTitulo("EndGame");
		libro.setAno((short) 2019);
		libro.setPrecio(2000);
		assertNotNull(libro);
		assertTrue(!libro.equals(""));
		List<Integer> listaAutores = new ArrayList<Integer>();
		listaAutores.add(100);
		assertNotNull(listaAutores);
		assertTrue(!listaAutores.isEmpty());
		Libro_Autor libroautor = new Libro_Autor(libro.getId_libro(), listaAutores);
		assertNotNull(libroautor);
		assertTrue(!libroautor.equals(""));
		libroBusiness.saveLibro(libro, libroautor);
	}

}
