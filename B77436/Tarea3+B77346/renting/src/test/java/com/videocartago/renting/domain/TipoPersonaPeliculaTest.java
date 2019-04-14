package com.videocartago.renting.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.factoryAbstract.PeliculaAbstract;
import com.videocartago.renting.tipoAbstract.TipoPersona_PeliculaAbstract;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipoPersonaPeliculaTest {
	
	
	@Test
	public void probarFactoryTipo1() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("El rey");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		Genero genero = new Genero(3000,"Infantil");
		pelicula.setGenero(genero);
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1,"Luis","Fernando"));
		actores.add(new Actor(2,"Marta","Soto"));
		TipoPersonaPelicula tipoPersona = new TipoPersonaPelicula();
		PeliculaAbstract mipelicula = tipoPersona.elegirTipoDeTelevidente(pelicula);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, mipelicula.getTitulo()+" Para: "+mipelicula.getTipo());
	}
	
	@Test
	public void probarFactoryTipo2() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(4);
		pelicula.setTitulo("Conjuro");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		Genero genero = new Genero(3000,"Terror");
		pelicula.setGenero(genero);
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1,"Albert","Fonseca"));
		actores.add(new Actor(2,"Maria","Solano"));
		TipoPersonaPelicula tipoPersona = new TipoPersonaPelicula();
		PeliculaAbstract mipelicula = tipoPersona.elegirTipoDeTelevidente(pelicula);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, mipelicula.getTitulo()+" Para: "+mipelicula.getTipo());
	}
	
	@Test
	public void probarFactoryTipo3() {
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(3);
		pelicula.setTitulo("La ventana");
		pelicula.setTotalPeliculas(3);
		pelicula.setSubtitulada(true);
		pelicula.setEstreno(false);
		Genero genero = new Genero(3000,"Suspenso");
		pelicula.setGenero(genero);
		List<Actor> actores = new ArrayList<Actor>();
		actores.add(new Actor(1,"Luis","Fernando"));
		actores.add(new Actor(2,"Marta","Soto"));
		TipoPersonaPelicula tipoPersona = new TipoPersonaPelicula();
		PeliculaAbstract mipelicula = tipoPersona.elegirTipoDeTelevidente(pelicula);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, mipelicula.getTitulo()+" Para: "+mipelicula.getTipo());
	}
}
