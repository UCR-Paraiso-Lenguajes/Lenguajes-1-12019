package com.videocartago.renting.patronIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.patronFactory.CategoriaPelicula_Factoria;
import com.videocartago.renting.patronFactory.CategoriaPelicula_Producto;

public class PatronIteratorTest {
	
	Genero genero;
	CategoriaPelicula_Factoria categoriaPelicula_Factoria;
	CategoriaPelicula_Producto categoriaPelicula_Producto;

	@Test
	public void test() {

		Pelicula pelicula = new Pelicula();
		genero = new Genero(101, "Accion");
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(100, "Jeremy", "Renner"));
		actores.add(new Actor(101, "Robert", "Downey Jr"));
		actores.add(new Actor(102, "Mark", "Rufalo"));

		pelicula.setActores(actores);
		pelicula.setGenero(genero);
		pelicula.setCodPelicula(12);
		pelicula.setTitulo("Avengers Endgame");
		pelicula.setTotalPeliculas(49);
		pelicula.setEstreno(true);
		pelicula.setSubtitulada(false);

		try {
			
			AgregadoConcreto agregado = new AgregadoConcreto();
			Iterador iterador = agregado.getIterador();
			// Crear el objeto agregado 
			agregado = new AgregadoConcreto();
			//Agregar a lista con los nombres
			agregado.llenarIterador("Hola", pelicula.getTitulo());
			pelicula.setTitulo("Capitan America");
			agregado.llenarIterador("Hola", pelicula.getTitulo());
			pelicula.setTitulo("Hulk");
			agregado.llenarIterador("Hola", pelicula.getTitulo());
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
				Logger.getLogger(getClass().getName()).log(Level.INFO, (String) iterador.siguiente() );
			}
			// Todo el objecto lleno
			Logger.getLogger(getClass().getName()).log(Level.INFO, (String) iterador.lista() );

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
