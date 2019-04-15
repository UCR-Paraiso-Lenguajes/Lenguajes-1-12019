package com.videocartago.renting.domain;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Genero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaTest {
	private Pelicula pelicula;
	private Genero genero;
	@Test
	public void peliculaTest() {
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
		
		assertTrue(pelicula!=null);
	}
}
