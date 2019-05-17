package com.videcartago.renting.domain;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.videcartago.renting.domain.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoraTest {
	Productora productora=Productora.getProductora();
	
	@Test
	public void test() {
			boolean contenidoAgregado=productora.agregarContenido(new Video("4:04 minutos","Video Musica","RAMONES - Poison Heart"));
			assertTrue(contenidoAgregado);
	}

}
