package com.videcartago.renting.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaTest {
	private Pelicula pelicula=new Pelicula("","");
	@Test
	public void test() {
		String renta=pelicula.rentar();
		assertEquals("rentada", renta);
		
		 /**TEST PARA LA EXCEPCION CUANDO LA PELICULA YA ESTA RENTADA
		  * renta=pelicula.rentar();
		assertEquals("rentada", renta);**/
		
		String disponible=pelicula.devolver();
		assertEquals("disponible", disponible);
		
		 /**TEST PARA LA EXCEPCION CUANDO LA PELICULA YA FUE DEVUELTA
		  * disponible=pelicula.devolver();
		assertEquals("disponible", disponible);**/
	}

}
