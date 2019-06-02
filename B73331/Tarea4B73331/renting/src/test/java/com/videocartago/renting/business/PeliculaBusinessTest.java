package com.videocartago.renting.business;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaBusinessTest {
	@Autowired
	public PeliculaBusiness peliculaBussines;
	@Test 
	public void findAllMoviesByTitleAndGenreTest() {
		String title = "BMW"; String genre = "Suspenso3";
		List<Pelicula> peliculas = peliculaBussines.findAllMoviesByTitleAndGenre(title, genre);
		assertNotNull(peliculas);
		assertTrue(!peliculas.isEmpty());
	}
	@Test
	public void saveTest() {
		Pelicula pelicula = new Pelicula();
		Genero g = new Genero(1000, "Suspenso3");
		pelicula.setCodPelicula(111);
		pelicula.setTitulo("MCD");
		pelicula.setGenero(g);
		pelicula.setTotalPeliculas(5);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(true);
		
		try {
			peliculaBussines.save(pelicula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
}
