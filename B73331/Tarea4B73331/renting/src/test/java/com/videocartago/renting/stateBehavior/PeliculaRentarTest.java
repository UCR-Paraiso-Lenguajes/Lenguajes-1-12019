package com.videocartago.renting.stateBehavior;

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
public class PeliculaRentarTest {
	private Pelicula pelicula;
	private Genero genero;
	
	public Pelicula llenarPelicula() {
		pelicula = new Pelicula();
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
		
		return pelicula;
	}
	@Test
	public void rentarPeliculaTestInicio() {
		Pelicula pelicula = llenarPelicula();
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##ConstructorTest==La pelicula esta disponible: "+pelicula.getEstado());
	}
	@Test
	public void rentarPeliculaTest() {
		Pelicula pelicula = llenarPelicula();
		EstadoRenta estado = new EstadoRenta();//Por default ya esta disponible para ponerla en false
		pelicula.setEstadoRentada(estado);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##rentarPeliculaTest==La pelicula esta disponible: "+pelicula.getEstado());
	}
	@Test
	public void disponiblePeliculaTest() {
		Pelicula pelicula = llenarPelicula();
		EstadoRenta estado = new EstadoRenta();
		pelicula.setEstadoRentada(estado);//La pongo en false(esta rentada) para devolverla
		pelicula.setEstadoDisponible(estado);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##disponiblePeliculaTest==La pelicula esta disponible: "+pelicula.getEstado());
	}
	@Test
	public void rentarPeliculaTestErr() {
		Pelicula pelicula = llenarPelicula();
		EstadoRenta estado = new EstadoRenta();//La pongo como anteriormente rentada
		pelicula.setEstadoRentada(estado);
		pelicula.setEstadoRentada(estado);
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##rentarPeliculaTest==La pelicula esta disponible: "+pelicula.getEstado());
	}
	@Test
	public void disponiblePeliculaTestErr() {
		Pelicula pelicula = llenarPelicula();
		EstadoRenta estado = new EstadoRenta();
		pelicula.setEstadoDisponible(estado);//Ya esta disponible anteriormente
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##disponiblePeliculaTest==La pelicula esta disponible: "+pelicula.getEstado());
	}
}
