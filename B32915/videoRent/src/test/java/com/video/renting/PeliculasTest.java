package com.video.renting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

import com.video.renting.domain.EstadoPeliculas;
import com.video.renting.domain.Pelicula;
import com.video.renting.domain.PeliculasRentadas;
import com.video.renting.domain.PeliculasStock;

public class PeliculasTest {

	@Autowired
	public PeliculasRentadas pelisRentadas;
	public PeliculasStock pelisStock;
	public Pelicula peli;
	
	@RunWith(Parameterized.class)public class ParameterizedTestUsingConstructor {

	    private Pelicula pelicula;

	    public ParameterizedTestUsingConstructor(Pelicula pelicula) {
	        pelicula = pelicula;
	    }
	
	@Test
	public void test() {
	
		pelisRentadas.Devolver(peli);
		
		pelisStock.Devolver(peli);
	
		pelisRentadas.Rentar(peli);
		
		pelisStock.Rentar(peli);
	}

	
	}
}
