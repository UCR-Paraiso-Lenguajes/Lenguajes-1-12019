package com.videocartago.renting.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoraTest {
	
	
	@Test
	public void probarProductora() {
		Productora productora = Productora.getInstance();
		productora.setContenidoProductora("Clip");
		assertNotNull(productora);
		assertTrue(!productora.equals(""));
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.getContenidoProductora());
		
		Productora productora2 = Productora.getInstance();
		productora2.setContenidoProductora("videos");
		assertNotNull(productora2);
		assertTrue(!productora2.equals(""));
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora2.getContenidoProductora());
		
		Productora productora3 = Productora.getInstance();
		productora3.setContenidoProductora("pelicula");
		assertNotNull(productora3);
		assertTrue(!productora3.equals(""));
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora3.getContenidoProductora());
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.getContenidoProductora());
		
	}

}
