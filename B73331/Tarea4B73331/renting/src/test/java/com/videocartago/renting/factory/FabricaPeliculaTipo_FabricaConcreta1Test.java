package com.videocartago.renting.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;
import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.domain.PeliculaMayores18;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FabricaPeliculaTipo_FabricaConcreta1Test {
	private Genero genero;
	private Pelicula_TipoAbstracta peliculaTipo;
	private FabricaPeliculaTipo_FabricaConcreta1 fabrica;
	@Test
	public void testingPeliculaTP() {
		Pelicula pelicula = new Pelicula();
		genero = new Genero(2, "Happy");
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1, "Jeremy", "Fonseca Medez"));
		actores.add(new Actor(2, "Emmanuel", "Solano Navarro"));
		
		pelicula.setActores(actores);
		pelicula.setCodPelicula(152);
		pelicula.setEstreno(true);
		pelicula.setSubtitulada(true);
		pelicula.setGenero(genero);
		pelicula.setTitulo("Los cuentos de mi tia panchita");
		pelicula.setTotalPeliculas(5);
		
		fabrica=new FabricaPeliculaTipo_FabricaConcreta1();
		peliculaTipo = fabrica.crearPelicula(pelicula);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, peliculaTipo.getTitulo()+"\nGenero:  "+peliculaTipo.getGenero().getNombreGenero()+"\n  Tipo de pelicula:  "+peliculaTipo.getTipo());
	}
	@Test
	public void testingPeliculaMay18() {
		Pelicula pelicula = new Pelicula();
		genero = new Genero(2, "Terror");
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1, "Jeremy", "Fonseca Medez"));
		actores.add(new Actor(2, "Emmanuel", "Solano Navarro"));
		
		pelicula.setActores(actores);
		pelicula.setCodPelicula(152);
		pelicula.setEstreno(true);
		pelicula.setSubtitulada(true);
		pelicula.setGenero(genero);
		pelicula.setTitulo("Los cuentos de mi tia panchita");
		pelicula.setTotalPeliculas(5);
		
		fabrica=new FabricaPeliculaTipo_FabricaConcreta1();
		peliculaTipo = fabrica.crearPelicula(pelicula);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, peliculaTipo.getTitulo()+"\nGenero:  "+peliculaTipo.getGenero().getNombreGenero()+"\n  Tipo de pelicula:  "+peliculaTipo.getTipo());
	}
	@Test
	public void testingPeliculaMay12() {
		Pelicula pelicula = new Pelicula();
		genero = new Genero(2, "Suspenso");
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1, "Jeremy", "Fonseca Medez"));
		actores.add(new Actor(2, "Emmanuel", "Solano Navarro"));
		
		pelicula.setActores(actores);
		pelicula.setCodPelicula(152);
		pelicula.setEstreno(true);
		pelicula.setSubtitulada(true);
		pelicula.setGenero(genero);
		pelicula.setTitulo("Los cuentos de mi tia panchita");
		pelicula.setTotalPeliculas(5);
		
		fabrica=new FabricaPeliculaTipo_FabricaConcreta1();
		peliculaTipo = fabrica.crearPelicula(pelicula);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, peliculaTipo.getTitulo()+"\nGenero:  "+peliculaTipo.getGenero().getNombreGenero()+"\n  Tipo de pelicula:  "+peliculaTipo.getTipo());
	}
}
