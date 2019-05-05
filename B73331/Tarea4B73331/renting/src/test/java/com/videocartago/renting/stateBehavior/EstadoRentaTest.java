package com.videocartago.renting.stateBehavior;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoRentaTest {
	private EstadoRenta estado = new EstadoRenta();
	@Test
	public void testingEstadoRentarTest(){
		boolean disponible = estado.rentar();
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##testingEstadoRentarTest==La pelicula esta disponible: "+disponible);
		
	}
	@Test
	public void testingEstadoDevolverTest(){
		boolean disponible = estado.devolver();
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, "##testingEstadoDevolverTest==La pelicula esta disponible: "+disponible);
		
	}
}
