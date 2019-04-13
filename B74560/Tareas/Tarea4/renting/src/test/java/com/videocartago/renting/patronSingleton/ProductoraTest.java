package com.videocartago.renting.patronSingleton;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.patronSingleton.Productora;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductoraTest {
	Productora productora;
	@Test
	public void productoraTest() {
		productora = Productora.getInstance();
		productora.setTipoContenido("Clíps");
		Logger.getLogger(getClass().getName()).log(Level.INFO, productora.getTipoContenido());

	}

}