package com.videocartago.renting.patronFactory;

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

public class patronFactoryTest {

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

		// pruebas de CategoriaTipo Todo Publico
		categoriaPelicula_Factoria = new CategoriaPelicula_Factoria();
		categoriaPelicula_Producto = categoriaPelicula_Factoria.categoriaPelicula_Producto(pelicula);
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"La pelicula: " + categoriaPelicula_Producto.getPelicula().getTitulo() + " de "
						+ categoriaPelicula_Producto.getPelicula().getGenero().getNombreGenero() + " es categoria: "
						+ categoriaPelicula_Producto.getCategoriaEdad());

		// pruebas de CategoriaTipo Mayores de 12
		genero = new Genero(102, "Suspenso");
		pelicula.setGenero(genero);

		categoriaPelicula_Factoria = new CategoriaPelicula_Factoria();
		categoriaPelicula_Producto = categoriaPelicula_Factoria.categoriaPelicula_Producto(pelicula);
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"La pelicula: " + categoriaPelicula_Producto.getPelicula().getTitulo() + " de "
						+ categoriaPelicula_Producto.getPelicula().getGenero().getNombreGenero() + " es categoria: "
						+ categoriaPelicula_Producto.getCategoriaEdad());

		// pruebas de CategoriaTipo Mayores de 18
		genero = new Genero(103, "Terror");
		pelicula.setGenero(genero);

		categoriaPelicula_Factoria = new CategoriaPelicula_Factoria();
		categoriaPelicula_Producto = categoriaPelicula_Factoria.categoriaPelicula_Producto(pelicula);
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"La pelicula: " + categoriaPelicula_Producto.getPelicula().getTitulo() + " de "
						+ categoriaPelicula_Producto.getPelicula().getGenero().getNombreGenero() + " es categoria: "
						+ categoriaPelicula_Producto.getCategoriaEdad());
	}

}
