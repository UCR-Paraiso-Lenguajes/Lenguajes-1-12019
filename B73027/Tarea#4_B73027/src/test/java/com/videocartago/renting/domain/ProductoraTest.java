package com.videocartago.renting.domain;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductoraTest {
	
	private ProductoraPelicula productora = ProductoraPelicula.getInstance();
	
	@Test
	public void productoraTest()
	{
		productora.setTipo("pelicula");
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.toString());
	
	}
     
}
