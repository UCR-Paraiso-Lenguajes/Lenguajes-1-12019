package com.videocartago.renting.comportamiento.state;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.comportamiento.state.EstadoDevuelto;
import com.videocartago.renting.comportamiento.state.EstadoPeliculas;
import com.videocartago.renting.comportamiento.state.EstadoRenta;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaEstadoTest {
	
	@Test
	public void estadosPeliculas() {
		Pelicula pelicula = new Pelicula();
		EstadoRenta estadoRenta = new EstadoRenta();
		EstadoDevuelto estadoDevuelto = new EstadoDevuelto();
		
		pelicula.setEstadoRentado(estadoRenta);
		assertTrue(estadoRenta.rentar());
		pelicula.setEstadoRentado(estadoDevuelto);
		assertTrue(estadoDevuelto.devolver());
		pelicula.setEstadoDevuelto(estadoDevuelto);
		assertTrue(estadoDevuelto.devolver());
		
	}
	
	@Test
	public void estadoPeliculas2() {
		Pelicula pelicula = new Pelicula();
		EstadoDevuelto estadoDevuelto = new EstadoDevuelto();
		EstadoRenta estadoRenta = new EstadoRenta();
		
		pelicula.setEstadoDevuelto(estadoDevuelto);
		assertTrue(estadoDevuelto.devolver());
		pelicula.setEstadoRentado(estadoRenta);
		assertTrue(estadoRenta.rentar());
	}

}
