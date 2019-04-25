package com.videcartago.renting.domain;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimientoTest {
	private Pelicula pelicula=new Pelicula("","");
	private MovimientosIterable movimientosIterable=new MovimientosIterable();
	@Test
	public void test() {
		//String renta=pelicula.rentar();
		
	//	String disponible=pelicula.devolver();
		
		
		movimientosIterable=pelicula.getMovimientosIterable();
		assertFalse(movimientosIterable.isEmpty());//se utiliza isEmpty, agregar y hasNext
				
	}

}
