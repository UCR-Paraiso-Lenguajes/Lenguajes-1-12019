package com.videocartago.renting.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaBusinessTest {
	@Autowired
	PeliculaBusiness peliculaBusiness;

	@Test
	public void nullInPelicula() {
		try {
			peliculaBusiness.save(null);
			assertTrue(false);
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	@Test
	public void inTitlePelicula() {
		try {
			Pelicula pelicula = new Pelicula();
			pelicula.setTitulo(
					"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			peliculaBusiness.save(pelicula);
			assertTrue(false);
		} catch (RuntimeException e) {
			assertEquals("el nombre no puede tener mas de 200 caracteres", e.getMessage());
		}
	}
}
