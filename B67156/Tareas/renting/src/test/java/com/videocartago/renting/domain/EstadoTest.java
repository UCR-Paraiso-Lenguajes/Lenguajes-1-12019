package com.videocartago.renting.domain;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoTest {
	
	@Test
	public void pruebaEstado() {
		Rentada rentada = new Rentada();
		Disponible disponible = new Disponible();
		Pelicula pelicula = new Pelicula();
		
		pelicula.difineEstado(disponible);
		pelicula.setEstadoString(pelicula.Rentar()+"");
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, pelicula.toString());
		
		pelicula.difineEstado(rentada);
		pelicula.setEstadoString(pelicula.Rentar()+"");
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, pelicula.toString());
		
		assertNotNull(pelicula);
	}

}
