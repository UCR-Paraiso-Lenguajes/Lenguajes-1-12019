package com.videocartago.renting.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.business.DefineEstadoPeliculas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoTest {
	
	@Test
	public void pruebaEstado() {
		DefineEstadoPeliculas defineEstado = new DefineEstadoPeliculas();
		Rentada rentada = new Rentada();
		Disponible disponible = new Disponible();
		Pelicula pelicula = new Pelicula();
		
		defineEstado.setEstado(disponible);
		pelicula.setEstado(defineEstado.definirEstado());
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, pelicula.toString());
		
		defineEstado.setEstado(rentada);
		pelicula.setEstado(defineEstado.definirEstado());
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, pelicula.toString());
	}

}
