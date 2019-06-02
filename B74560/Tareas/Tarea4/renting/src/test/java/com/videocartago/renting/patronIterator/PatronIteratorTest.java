package com.videocartago.renting.patronIterator;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.exception.RentingException;
import com.videocartago.renting.patronFactory.CategoriaPeliculaFactoria;
import com.videocartago.renting.patronFactory.CategoriaPeliculaProducto;

public class PatronIteratorTest {
	
	Genero genero;
	CategoriaPeliculaFactoria categoriaPeliculaFactoria;
	CategoriaPeliculaProducto categoriaPeliculaProducto;

	@Test
	public void test() {

		Pelicula pelicula = new Pelicula();
		genero = new Genero(101, "Accion");
		assertNotNull("Genero vacío", genero);
		
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(100, "Jeremy", "Renner"));
		actores.add(new Actor(101, "Robert", "Downey Jr"));
		actores.add(new Actor(102, "Mark", "Rufalo"));
		assertNotNull("Actor vacío", actores);
		
		pelicula.setActores(actores);
		pelicula.setGenero(genero);
		pelicula.setCodPelicula(12);
		pelicula.setTitulo("Avengers Endgame");
		pelicula.setTotalPeliculas(49);
		pelicula.setEstreno(true);
		pelicula.setSubtitulada(false);
		assertNotNull("Película vacía", pelicula);

		try {
			
			AgregadoConcreto agregado = new AgregadoConcreto();
			Iterador iterador = agregado.getIterador();
			// Crear el objeto agregado 
			agregado = new AgregadoConcreto();
			//Agregar a lista con los nombres
			agregado.llenarIterador("Rentada", pelicula.getTitulo());
			pelicula.setTitulo("Capitan America");
			assertNotNull("Película vacía", pelicula);
			agregado.llenarIterador("Devuelta", pelicula.getTitulo());
			pelicula.setTitulo("Hulk");
			assertNotNull("Película vacía", pelicula);
			agregado.llenarIterador("Rentada", pelicula.getTitulo());
			// Crear el objeto iterador para recorrer la lista
			iterador = agregado.getIterador();
			// Mover dos posiciones adelante
			iterador.siguiente();
			iterador.siguiente();
			// Mostrar el elemento actual
			// Volver al principio
			iterador.primero();
			// Recorrer todo
			while (iterador.hayMas() == true) {
				assertNotNull("Lista vacía", iterador.hayMas());
				Logger.getLogger(getClass().getName()).log(Level.INFO, (String) iterador.siguiente() );
			}
			// Todo el objecto lleno
			assertNotNull("Lista vacía", iterador.lista());
			Logger.getLogger(getClass().getName()).log(Level.INFO, (String) iterador.lista() );
			

		} catch (Exception e) {
			throw new RentingException("Error al cargar los datos");
		}  
	}
}
