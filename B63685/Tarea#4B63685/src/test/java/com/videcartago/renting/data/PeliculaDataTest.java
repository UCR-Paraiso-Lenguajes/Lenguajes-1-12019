package com.videcartago.renting.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit4.SpringRunner;

import com.videcartago.renting.domain.Genero;
import com.videcartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaDataTest {
	@Autowired
	private PeliculaData peliculaData;

	@Test
	public void findMoviesByTitleAndGenre() 
	{
		List<Pelicula> peliculas = peliculaData.findMoviesByTitleAndGenre("time", "suspenso");
		assertNotNull(peliculas);
		assertTrue(!peliculas.isEmpty());
		
	}
	
	@Test
	public void saveTest() 
	{
		Pelicula p = new Pelicula();
		Genero g = new Genero();
		g.setCodGenero(1000);
		
		p.setCodPelicula(100);
		p.setTitulo("Endgame");
		p.setGenero(g);
		p.setTotalPeliculas(100);
		p.setSubtitulada(true);
		p.setEstreno(true);
		
		Pelicula resultado = null;

		resultado = peliculaData.save(p);

		assertTrue(resultado.getCodPelicula() != 0);
		
	}
}


