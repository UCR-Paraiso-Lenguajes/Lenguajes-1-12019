package com.videocartago.renting.patronSingleton;

import static org.junit.Assert.*;

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
		assertNotNull("Vacío getTipoContenido", productora.getTipoContenido());
		Logger.getLogger(getClass().getName()).log(Level.INFO, productora.getTipoContenido());
		
	}

}