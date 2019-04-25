package com.videcartago.renting.domain;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaTest {
	private	 Pelicula pelicula=new Pelicula("","");
	@Test
	public  void test() {
		pelicula.rentar();
		EstadoComparacion estadoCompacion=pelicula.getEstadoComparacion();
		assertTrue(estadoCompacion==estadoCompacion.rentada);
		
		 /**TEST PARA LA EXCEPCION CUANDO LA PELICULA YA ESTA RENTADA**/
		pelicula.rentar();
		estadoCompacion=pelicula.getEstadoComparacion();
		assertTrue(estadoCompacion==estadoCompacion.rentada);
		
		pelicula.devolver();
		estadoCompacion=pelicula.getEstadoComparacion();
		assertTrue(estadoCompacion==estadoCompacion.disponible);
		
		 /**TEST PARA LA EXCEPCION CUANDO LA PELICULA YA FUE DEVUELTA**/
		pelicula.devolver();
		estadoCompacion=pelicula.getEstadoComparacion();
		assertTrue(estadoCompacion==estadoCompacion.disponible);
	}

}
