package com.videocartago.renting.Factory;

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

@RunWith(SpringRunner.class)
@SpringBootTest

public class PeliculaFactoryTest {
	
	@Test
	public void FactoryTest() {
	Pelicula pelicula = new Pelicula();
	Genero genero = new Genero(2, "Terror");
	List<Actor> actores = new ArrayList<Actor>();
	actores.add(new Actor(1, "Maurio", "Fonseca Medez"));
	actores.add(new Actor(2, "Yendry", "Mendez Abarca"));
	
	pelicula.setActores(actores);
	pelicula.setCodPelicula(150);
	pelicula.setEstreno(true);
	pelicula.setSubtitulada(true);
	pelicula.setGenero(genero);
	pelicula.setTitulo("Alicia en el pais de las mascotas");
	pelicula.setTotalPeliculas(5);
	
	FabricaPeliculasCategoria fabrica =new FabricaPeliculasCategoria();
	PeliculaAbtractTipo peliculaAbstractTipo = fabrica.categoriaEdad(pelicula);
	
	Logger.getLogger(getClass().getName()).log(
            Level.INFO, peliculaAbstractTipo.getTitulo()+"  Categoria: "+peliculaAbstractTipo.getCategoriaEdad());
	}
	
	@Test
	public void FactoryTest2() {
	Pelicula pelicula = new Pelicula();
	Genero genero = new Genero(2, "Suspenso");
	List<Actor> actores = new ArrayList<Actor>();
	actores.add(new Actor(1, "Carlos", "Orozco Loria"));
	actores.add(new Actor(2, "Pacha", "Carrasco Abarca"));
	
	pelicula.setActores(actores);
	pelicula.setCodPelicula(150);
	pelicula.setEstreno(true);
	pelicula.setSubtitulada(true);
	pelicula.setGenero(genero);
	pelicula.setTitulo("El pollito pio");
	pelicula.setTotalPeliculas(5);
	
	FabricaPeliculasCategoria fabrica =new FabricaPeliculasCategoria();
	PeliculaAbtractTipo peliculaAbstractTipo = fabrica.categoriaEdad(pelicula);
	
	Logger.getLogger(getClass().getName()).log(
            Level.INFO, peliculaAbstractTipo.getTitulo()+"  Categoria: "+peliculaAbstractTipo.getCategoriaEdad());
	}
	
	@Test
	public void FactoryTest3() {
	Pelicula pelicula = new Pelicula();
	Genero genero = new Genero(2, "Comedia");
	List<Actor> actores = new ArrayList<Actor>();
	actores.add(new Actor(1, "Aaron", "Mata Loria"));
	actores.add(new Actor(2, "Emmanuel", "Navarro"));
	
	pelicula.setActores(actores);
	pelicula.setCodPelicula(150);
	pelicula.setEstreno(true);
	pelicula.setSubtitulada(true);
	pelicula.setGenero(genero);
	pelicula.setTitulo("Mas rapido mas furioso");
	pelicula.setTotalPeliculas(5);
	
	FabricaPeliculasCategoria fabrica =new FabricaPeliculasCategoria();
	PeliculaAbtractTipo peliculaAbstractTipo = fabrica.categoriaEdad(pelicula);
	
	Logger.getLogger(getClass().getName()).log(
            Level.INFO, peliculaAbstractTipo.getTitulo()+"  Categoria: "+peliculaAbstractTipo.getCategoriaEdad());
	}

}
