package com.videocartago.renting.testPatrones;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.videcartago.renting.domain.Pelicula;
import com.videcartago.renting.domain.Rentada;
import com.videcartago.renting.domain.Stock;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatronState {

	@Test
	public void test() {
		
		
		
		Pelicula pelicula = new Pelicula();
		pelicula.setEstado(new Rentada());
		pelicula.setEstado(new Stock());

		
		
		Logger.getLogger(getClass().getName()).log(Level.INFO, "mostrar estado de la pelicula:"+pelicula.getEstado());

	}

}
