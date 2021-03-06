package com.videocartago.renting.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.comportamiento.state.EstadoDevuelto;
import com.videocartago.renting.comportamiento.state.EstadoPeliculas;
import com.videocartago.renting.comportamiento.state.EstadoRenta;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaTest {

	@Test
	public void probarPelicula() {
		Pelicula pelicula = new Pelicula(); 
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("Airplane");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		pelicula.setGenero(new Genero(2000,"Comedia"));
		List<Actor> listActores = new ArrayList<Actor>();
		listActores.add(new Actor(6, "Dennis","Leary"));
		assertNotNull(listActores);
		assertTrue(!listActores.isEmpty());
		pelicula.setActores(listActores);
		assertNotNull(pelicula);
		assertTrue(!pelicula.equals(""));
		
		EstadoRenta estadoPelicula = new EstadoRenta();
		pelicula.setEstadoDevuelto(estadoPelicula);
		EstadoDevuelto estadoDevuelto = new EstadoDevuelto();
		pelicula.setEstadoDevuelto(estadoDevuelto);
	
	}
}
