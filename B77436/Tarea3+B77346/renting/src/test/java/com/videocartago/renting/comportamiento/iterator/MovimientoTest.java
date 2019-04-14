package com.videocartago.renting.comportamiento.iterator;

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
		try
        {
			Pelicula pelicula = new Pelicula();
			
			pelicula.setCodPelicula(3);
			pelicula.setTitulo("Airplane");
			pelicula.setTotalPeliculas(3);
			pelicula.setSubtitulada(true);
			pelicula.setEstreno(false);
			pelicula.setGenero(new Genero(2000,"Comedia"));
			List<Actor> listActores = new ArrayList<Actor>();
			listActores.add(new Actor(6, "Dennis","Leary"));
			pelicula.setActores(listActores);
			
			Movimientos agregado = new Movimientos();
			Iterador iterador = agregado.getIterador();
			List<String> listaEstadosPeliculas = new ArrayList<String>();
			
			listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
			listaEstadosPeliculas.add("Devuelta "+pelicula.getTitulo());
        	agregado = new Movimientos(listaEstadosPeliculas);
	        iterador = agregado.getIterador();
			
        	while( iterador.hayMasElementos() == true ) {
        		Logger.getLogger(getClass().getName()).log(
    		            Level.INFO, "..............."+iterador.siguiente());
            }
        }
        catch( Exception ex ){
        	ex.printStackTrace();
            
        }
	}
	
	@Test
	public void probarIterator2() {
		try
        {
			Pelicula pelicula = new Pelicula();
			
			pelicula.setCodPelicula(3);
			pelicula.setTitulo("Endgame");
			pelicula.setTotalPeliculas(3);
			pelicula.setSubtitulada(true);
			pelicula.setEstreno(false);
			pelicula.setGenero(new Genero(2000,"Accion"));
			List<Actor> listActores = new ArrayList<Actor>();
			listActores.add(new Actor(6, "Dennis","Leary"));
			pelicula.setActores(listActores);
			
			Movimientos agregado = new Movimientos();
			Iterador iterador = agregado.getIterador();
			List<String> listaEstadosPeliculas = new ArrayList<String>();
			
			listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
			listaEstadosPeliculas.add("Devuelta "+pelicula.getTitulo());
			listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
			listaEstadosPeliculas.add("Devuelta "+pelicula.getTitulo());
			listaEstadosPeliculas.add("Rentada "+pelicula.getTitulo());
        	agregado = new Movimientos(listaEstadosPeliculas);
	        iterador = agregado.getIterador();
			
        	while( iterador.hayMasElementos() == true ) {
        		Logger.getLogger(getClass().getName()).log(
    		            Level.INFO, "..............."+iterador.siguiente());
            }
        }
        catch( Exception ex ){
        	ex.printStackTrace();
            
        }
	}
	
	
}
