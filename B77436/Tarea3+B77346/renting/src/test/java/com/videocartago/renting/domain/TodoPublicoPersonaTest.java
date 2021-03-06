package com.videocartago.renting.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.ls.LSInput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoPublicoPersonaTest {
	
	@Test
	public void probarTodoPublico() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("Dumbo");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		pelicula.setGenero(new Genero(2000,"Infantil"));
		List<Actor> listActores = new ArrayList<Actor>();
		listActores.add(new Actor(6, "Dennis","Leary"));
		assertNotNull(listActores);
		assertTrue(!listActores.isEmpty());
		pelicula.setActores(listActores);
		assertNotNull(pelicula);
		assertTrue(!pelicula.equals(""));
		TodoPublicoPersona todoPublico = new TodoPublicoPersona(pelicula);
		todoPublico.setCodPelicula(4);
		todoPublico.setTitulo("Rey leon");
		todoPublico.setTotalPeliculas(3);
		todoPublico.setSubtitulada(true);
		todoPublico.setEstreno(false);
		todoPublico.setGenero(new Genero(2000,"Infantil"));
		List<Actor> listActores2 = new ArrayList<Actor>();
		listActores2.add(new Actor(6, "Dennis","Leary"));
		assertNotNull(listActores2);
		assertTrue(!listActores2.isEmpty());
		todoPublico.setActores(listActores);
		todoPublico.getCodPelicula();
		todoPublico.getTotalPeliculas();
		todoPublico.getTitulo();
		todoPublico.getActores();
		assertNotNull(todoPublico);
		assertTrue(!todoPublico.equals(""));
	}
}
