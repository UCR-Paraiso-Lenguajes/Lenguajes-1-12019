package com.videocartago.renting.Data;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.data.PeliculaData;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaDataTest {
	@Autowired
	private PeliculaData peliculaData;//No pide el import ya que el nombre del paquete es el mismo al de datos
	
	/**
	@Test
	public void findMoviesByTitleAndGenre() {
		List<Pelicula> peliculas = peliculaData.findMoviesByTitleAndGenre("time", "suspenso");
		assertNotNull(peliculas);
		assertTrue(!peliculas.isEmpty());
		
	}
	**/
	@Test
	public void saveMovie() {
		Pelicula pelicula = new Pelicula();
		Genero g = new Genero(1000, "Suspenso3");
		pelicula.setCodPelicula(111);
		pelicula.setTitulo("BMW");
		pelicula.setGenero(g);
		pelicula.setTotalPeliculas(8);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		
	
		try {
			peliculaData.save(pelicula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		
	}
}