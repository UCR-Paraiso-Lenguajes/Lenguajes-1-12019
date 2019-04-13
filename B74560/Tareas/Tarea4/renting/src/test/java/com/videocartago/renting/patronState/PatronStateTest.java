package com.videocartago.renting.patronState;

import org.junit.Test;

import com.videocartago.renting.domain.Pelicula;

public class PatronStateTest {

	Pelicula pelicula = new Pelicula();
	DevolucionPelicula devolucionPelicula = new DevolucionPelicula();
	RentaPelicula rentaPelicula = new RentaPelicula();

	@Test
	public void rentarPelicula() {

		pelicula.setRentar(rentaPelicula);

	}

	@Test
	public void devolverPelicula() {

		pelicula.setDevolver(devolucionPelicula);

	}

	@Test
	public void rentarPeliculaException() {

		pelicula.setDevolver(rentaPelicula);

	}

	@Test
	public void devolverPeliculaException() {

		pelicula.setRentar(devolucionPelicula);

	}

}
