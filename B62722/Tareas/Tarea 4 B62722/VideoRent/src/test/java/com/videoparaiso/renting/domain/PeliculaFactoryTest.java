package com.videoparaiso.renting.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videoparaiso.renting.domain.factory.PeliculaFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaFactoryTest {
	
	 Genero genero = new Genero(1, "Comedia");
	 List<Actor> lista = new ArrayList<Actor>();
	 PeliculaFactory peliculaFactory = new PeliculaFactory(1, "Test", 2, false, false, genero, lista);

	@Test
	public void clasificarTest() {
		peliculaFactory.clasificar();
		assertNotNull(peliculaFactory.getClasificacion());
	}
}
