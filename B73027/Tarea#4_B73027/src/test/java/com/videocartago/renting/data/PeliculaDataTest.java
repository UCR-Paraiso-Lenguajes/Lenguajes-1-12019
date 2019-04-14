package com.videocartago.renting.data;

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
public class PeliculaDataTest {
	@Autowired
	private PeliculaData peliculaData;

	@Test
	public void findMoviesByTitleAndGenre() {
		List<Pelicula> peliculas = peliculaData.findMoviesByTitleAndGenre("time", "suspenso");
		assertNotNull(peliculas);
		assertTrue(!peliculas.isEmpty());
		
	}
	
	@Test
	public void saveTest() {
		Pelicula pelicula = new Pelicula();
		Genero g = new Genero();
		g.setCodGenero(1000);
		g.setNombreGenero("Ficcion");
		pelicula.setGenero(g);
		pelicula.setTotalPeliculas(4);
		pelicula.setTitulo("EndGame");
		pelicula.setCodPelicula(111);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(true);
		try {
			peliculaData.save(pelicula);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
}

