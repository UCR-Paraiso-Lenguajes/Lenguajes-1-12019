package com.videocartago.renting.domain;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeliculaFactoryTest {

	@Test
	public void test() {
		List<Actor> actoresDeLaPelicula = new LinkedList<Actor>();
		Genero generoDeLaPelicula = new Genero();
		PeliculaFactory peliculaFactory = new PeliculaFactory();
		Pelicula peliculaCreada = new Pelicula();
		peliculaCreada = peliculaFactory.crearPelicula(0, "Avengers", 20, true, false, generoDeLaPelicula, actoresDeLaPelicula,"Stock");
		
	}

}
