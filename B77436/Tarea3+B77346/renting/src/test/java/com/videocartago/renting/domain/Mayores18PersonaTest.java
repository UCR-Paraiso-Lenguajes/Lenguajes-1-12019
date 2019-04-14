package com.videocartago.renting.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mayores18PersonaTest {
	@Test
	public void probarMayor18() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("Eso");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		pelicula.setGenero(new Genero(2000,"Terror"));
		List<Actor> listActores = new ArrayList<Actor>();
		listActores.add(new Actor(6, "Dennis","Leary"));
		pelicula.setActores(listActores);
		Mayores18Persona mayores18 = new Mayores18Persona(pelicula);
		mayores18.setCodPelicula(4);
		mayores18.setTitulo("Conjuro");
		mayores18.setTotalPeliculas(3);
		mayores18.setSubtitulada(true);
		mayores18.setEstreno(false);
		mayores18.setGenero(new Genero(2000,"Terror"));
		List<Actor> listActores2 = new ArrayList<Actor>();
		listActores.add(new Actor(6, "Dennis","Leary"));
		mayores18.setActores(listActores);
		mayores18.getCodPelicula();
		mayores18.getTotalPeliculas();
		mayores18.getTitulo();
		mayores18.getActores();
	}
}
