package com.videocartago.renting.patrónState;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EstadoPeliculaTest {

	@Test
	public void estadosPeliculas() {
		Pelicula pelicula = new Pelicula();
		RentarPelicula rentarPelicula = new RentarPelicula();
		
		pelicula.setEstadoPeliculaRentada(rentarPelicula);
		
	}
	
	@Test
	public void estadoPeliculas2() {
		Pelicula pelicula = new Pelicula();
		DevolverPelicula devolverPelicula = new DevolverPelicula();
		pelicula.setEstadoPeliculaDevolver(devolverPelicula);
	}
	
	
	@Test
	public void estadosPeliculas3() {
		Pelicula pelicula = new Pelicula();
		RentarPelicula rentarPelicula = new RentarPelicula();
		
		pelicula.setEstadoPeliculaDevolver(rentarPelicula);
		
	}
	
	@Test
	public void estadoPeliculas4() {
		Pelicula pelicula = new Pelicula();
		DevolverPelicula devolverPelicula = new DevolverPelicula();
		pelicula.setEstadoPeliculaRentada(devolverPelicula);
	}

}
