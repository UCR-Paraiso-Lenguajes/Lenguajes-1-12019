package com.videocartago.renting.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneroTest {
	
	@Test
	public void probarGenero() {
		Genero genero = new Genero(2000,"Comedia");
		genero.setCodGenero(1000);
		genero.setNombreGenero("Suspenso3");
		genero.getCodGenero();
		genero.getNombreGenero();
	}

}
