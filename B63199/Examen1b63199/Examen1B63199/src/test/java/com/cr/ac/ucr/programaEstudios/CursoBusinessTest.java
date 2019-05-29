package com.cr.ac.ucr.programaEstudios;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Examen1B63199Application.class)
@SpringBootTest
public class CursoBusinessTest {

	@Test
	public void test() {
		
		//assert();
		fail("Not yet implemented");
	}
	
	

	public class PeliculaDataTest {
		@Autowired
		private PeliculaData peliculaData;
		
		@Test
		public void findMoviesByTitleAndGenre() {
			List<Pelicula> peliculas = peliculaData.findMoviesByTitleAndGenre("time", "suspenso");
			assertNotNull(peliculas);
			assertTrue(!peliculas.isEmpty());
		}
		
	}

}
