package com.videocartago.renting.comportamiento.iterator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.comportamiento.Iterator.Movimientos;
import com.videocartago.renting.comportamiento.Iterator.Iterador;
import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientoTest {
	
	
	
	@Test
	public void probarIterator() {
		
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
			
		Movimientos agregado = new Movimientos();
		Iterador iterador = agregado.getIterador();
		List<String> listaEstadosPeliculas = new ArrayList<String>();
		assertNotNull(listaEstadosPeliculas);
		
			
		listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
		listaEstadosPeliculas.add("Devuelta "+pelicula.getTitulo());
		assertNotNull(listaEstadosPeliculas);
		assertTrue(!listaEstadosPeliculas.isEmpty());
		
        agregado = new Movimientos(listaEstadosPeliculas);
	    iterador = agregado.getIterador();
	    assertNotNull(agregado);
	    assertTrue(!agregado.lista.isEmpty());
	  
			
        while( iterador.hayMasElementos() == true ) {
        	Logger.getLogger(getClass().getName()).log(
    		            Level.INFO, "..............."+iterador.siguiente());
        }
       
	}
	
	@Test
	public void probarIterator2() {
		
		Pelicula pelicula = new Pelicula();
			
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("Endgame");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		pelicula.setGenero(new Genero(2000,"Accion"));
		List<Actor> listActores = new ArrayList<Actor>();
		listActores.add(new Actor(6, "Dennis","Leary"));
		assertNotNull(listActores);
		assertTrue(!listActores.isEmpty());
		pelicula.setActores(listActores);
		assertNotNull(pelicula);
		assertTrue(!pelicula.equals(""));
			
		Movimientos agregado = new Movimientos();
		Iterador iterador = agregado.getIterador();
		List<String> listaEstadosPeliculas = new ArrayList<String>();
		
		listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
		listaEstadosPeliculas.add("Devuelta "+pelicula.getTitulo());
		listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
		listaEstadosPeliculas.add("Devuelta "+pelicula.getTitulo());
		listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
		assertNotNull(listaEstadosPeliculas);
		assertTrue(!listaEstadosPeliculas.isEmpty());
		
        agregado = new Movimientos(listaEstadosPeliculas);
	    iterador = agregado.getIterador();
	    assertNotNull(agregado);
	    assertTrue(!agregado.lista.isEmpty());
			
        while( iterador.hayMasElementos() == true ) {
        	Logger.getLogger(getClass().getName()).log(
    		          Level.INFO, "..............."+iterador.siguiente());
        }
	}
	
	
}
