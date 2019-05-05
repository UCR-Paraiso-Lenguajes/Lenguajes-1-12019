package com.videocartago.renting.patronFactory;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.patronFactory.CategoriaPeliculaFactoria;
import com.videocartago.renting.patronFactory.CategoriaPeliculaProducto;

public class patronFactoryTest {

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
		
		// pruebas de CategoriaTipo Todo Publico
		categoriaPeliculaFactoria = new CategoriaPeliculaFactoria();
		categoriaPeliculaProducto = categoriaPeliculaFactoria.categoriaPeliculaProducto(pelicula);
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"La pelicula: " + categoriaPeliculaProducto.getPelicula().getTitulo() + " de "
						+ categoriaPeliculaProducto.getPelicula().getGenero().getNombreGenero() + " es categoria: "
						+ categoriaPeliculaProducto.getCategoriaTipo());

		// pruebas de CategoriaTipo Mayores de 12
		genero = new Genero(102, "Suspenso");
		pelicula.setGenero(genero);
		assertNotNull("Genero vacío", genero);

		categoriaPeliculaFactoria = new CategoriaPeliculaFactoria();
		categoriaPeliculaProducto = categoriaPeliculaFactoria.categoriaPeliculaProducto(pelicula);
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"La pelicula: " + categoriaPeliculaProducto.getPelicula().getTitulo() + " de "
						+ categoriaPeliculaProducto.getPelicula().getGenero().getNombreGenero() + " es categoria: "
						+ categoriaPeliculaProducto.getCategoriaTipo());

		// pruebas de CategoriaTipo Mayores de 18
		genero = new Genero(103, "Terror");
		pelicula.setGenero(genero);
		assertNotNull("Genero vacío", genero);

		categoriaPeliculaFactoria = new CategoriaPeliculaFactoria();
		categoriaPeliculaProducto = categoriaPeliculaFactoria.categoriaPeliculaProducto(pelicula);
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"La pelicula: " + categoriaPeliculaProducto.getPelicula().getTitulo() + " de "
						+ categoriaPeliculaProducto.getPelicula().getGenero().getNombreGenero() + " es categoria: "
						+ categoriaPeliculaProducto.getCategoriaTipo());
	}

}
