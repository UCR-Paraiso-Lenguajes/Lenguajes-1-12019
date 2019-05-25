package com.videocartago.renting.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaTPTest {
	private PeliculaTP pelicula12;
	private Pelicula pelicula;
	private Genero genero;
	@Test
	public void testing() {
		pelicula = new Pelicula();
		genero = new Genero(2, "Suspenso");
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1, "Jeremy", "Fonseca Medez"));
		actores.add(new Actor(2, "Emmanuel", "Solano Navarro"));
		
		pelicula.setActores(actores);
		pelicula.setCodPelicula(152);
		pelicula.setEstreno(true);
		pelicula.setSubtitulada(true);
		pelicula.setGenero(genero);
		pelicula.setTitulo("Los cuentos de mi tia panchita");
		pelicula.setTotalPeliculas(5);

		pelicula12 = new PeliculaTP(pelicula);
		pelicula12.setTipo();
		System.out.println(pelicula12.getTitulo()+"#########"+pelicula12.getTipo());
	}
}
