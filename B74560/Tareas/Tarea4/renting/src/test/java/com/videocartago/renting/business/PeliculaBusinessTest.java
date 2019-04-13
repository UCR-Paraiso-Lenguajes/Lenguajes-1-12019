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
	private PeliculaBusiness peliculaBusiness;
	
	@Test
	public void findAllMoviesByTitleAndGenre() {
		List<Pelicula> pelicula = peliculaBusiness.findAllMoviesByTitleAndGenere("Airplane", "Comedia");
		assertNotNull(pelicula);
		assertTrue(!pelicula.isEmpty());
	}
	
	@Test
	public void save() {
		Pelicula pelicula = new Pelicula();
		Genero g = new Genero();
		g.setCodGenero(1000);
		g.setNombreGenero("Suspenso");
		pelicula.setGenero(g);
		pelicula.setTotalPeliculas(4);
		pelicula.setTitulo("Avengers");
		pelicula.setCodPelicula(111);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(true);
		try {
			peliculaBusiness.save(pelicula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
