package com.videocartago.renting.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.dao.PeliculaDao;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaDataTest {

	@Autowired
	private PeliculaDao peliculaData;

	@Test
	public void findMoviesByTitleAndGenre() {

		List<Pelicula> peliculas = peliculaData.findMoviesByTittleAndGenre("time", "suspenso");
		assertNotNull(peliculas);
		assertTrue(!peliculas.isEmpty());
	}

}
