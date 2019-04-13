package com.videoparaiso.renting.iterator;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videoparaiso.renting.domain.Actor;
import com.videoparaiso.renting.domain.Disponible;
import com.videoparaiso.renting.domain.Genero;
import com.videoparaiso.renting.domain.Pelicula;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IteradorTest {

	Date date;
	Genero genero = new Genero(1, "Comedia");
	List<Actor> lista = new ArrayList<Actor>();
	Pelicula pelicula = new Pelicula(2, "Test", 2, true, false, genero, lista);
	
	@Test
	public void insertarTest() {
		Movimientos movimientos = new Movimientos(date.getDate(), new Disponible(), pelicula);
		new Node(movimientos);
		assertNotNull(movimientos);
	}

}
