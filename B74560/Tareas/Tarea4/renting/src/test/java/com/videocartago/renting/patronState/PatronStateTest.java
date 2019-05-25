package com.videocartago.renting.patronState;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.videocartago.renting.domain.Pelicula;

public class PatronStateTest {

	Pelicula pelicula = new Pelicula();
	DevolucionPelicula devolucionPelicula = new DevolucionPelicula();
	RentaPelicula rentaPelicula = new RentaPelicula();

	@Test
	public void rentarPeliculaException() {
		
		assertTrue("No se puede rentar", 
				pelicula.rentar(rentaPelicula));
		pelicula.rentar(rentaPelicula);

	}

	@Test
	public void devolverPeliculaException() {
		
		assertTrue("No se puede rentar", 
				pelicula.devolver(devolucionPelicula));
		pelicula.devolver(devolucionPelicula);

	}

	@Test
	public void rentarPelicula() {

		assertTrue("No se puede rentar", 
				pelicula.devolver(rentaPelicula));
		pelicula.devolver(rentaPelicula);

	}

	@Test
	public void devolverPelicula() {
		
		assertTrue("No se puede rentar", 
				pelicula.rentar(devolucionPelicula));
		pelicula.rentar(devolucionPelicula);

	}

}
