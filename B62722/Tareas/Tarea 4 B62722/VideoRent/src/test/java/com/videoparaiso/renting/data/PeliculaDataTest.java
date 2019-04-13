package com.videoparaiso.renting.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videoparaiso.renting.domain.Disponible;
import com.videoparaiso.renting.domain.EstadoPelicula;
import com.videoparaiso.renting.domain.Pelicula;
import com.videoparaiso.renting.domain.Rentada;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaDataTest {
	
	private EstadoPelicula estado;
	private Pelicula pelicula;
	
	@Test
	public void rentarTest() {
		pelicula = new Pelicula();
		estado = new Rentada();
		pelicula.setEstado(estado);
		pelicula.estado();
		assertEquals(estado, pelicula.getEstado());
	}
	
	@Test
	public void devolverTest() {
		pelicula = new Pelicula();
		estado = new Disponible();
		pelicula.setEstado(estado);
		pelicula.estado();
		assertEquals(estado, pelicula.getEstado());
	}
}
