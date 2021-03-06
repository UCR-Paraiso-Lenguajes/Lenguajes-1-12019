package com.videocartago.renting.domain;

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
public class Mayores12PersonaTest {

	@Test
	public void provarMayores12Persona() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("Airplane");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		pelicula.setGenero(new Genero(2000,"Suspenso"));
		List<Actor> listActores = new ArrayList<Actor>();
		listActores.add(new Actor(6, "Dennis","Leary"));
		assertNotNull(listActores);
		assertTrue(!listActores.isEmpty());
		pelicula.setActores(listActores);
		assertNotNull(pelicula);
		assertTrue(!pelicula.equals(""));
		
		Mayores12Persona mayores12 = new Mayores12Persona(pelicula);
		mayores12.setCodPelicula(4);
		mayores12.setTitulo("Austin Powers");
		mayores12.setTotalPeliculas(3);
		mayores12.setSubtitulada(true);
		mayores12.setEstreno(false);
		mayores12.setGenero(new Genero(2000,"Suspenso"));
		List<Actor> listActores2 = new ArrayList<Actor>();
		listActores2.add(new Actor(6, "Dennis","Leary"));
		assertNotNull(listActores2);
		assertTrue(!listActores2.isEmpty());
		mayores12.setActores(listActores);
		mayores12.getCodPelicula();
		mayores12.getTotalPeliculas();
		mayores12.getTitulo();
		mayores12.getActores();
		assertNotNull(mayores12);
		assertTrue(!mayores12.equals(""));
	}
}
