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
	
	@Test
	public void getTipoContenido() {
		//-------------------------------------------
		Productora productora = Productora.getInstance();
		productora.setTipoContenido("Videos");
		
		Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora.toString());
        //-------------------------------------------
        Productora productora1 = Productora.getInstance();
        productora1.setTipoContenido("Clips");
        Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora1.toString());
        //-------------------------------------------
        Productora productora2 = Productora.getInstance();
        productora2.setTipoContenido("Peliculas");
        Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora2.toString());
        //-------------------------------------------
        Logger.getLogger(getClass().getName()).log(
	            Level.INFO, productora2.toString());
	}

}
