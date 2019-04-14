package com.videocartago.renting.domain;

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
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.getContenidoProductora());
		Productora productora2 = Productora.getInstance();
		productora2.setContenidoProductora("videos");
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora2.getContenidoProductora());
		Productora productora3 = Productora.getInstance();
		productora3.setContenidoProductora("pelicula");
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora3.getContenidoProductora());
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.getContenidoProductora());
	}

}
