package com.videcartago.renting.domain;

public class Rentada extends Estado{

	@Override
	public void rentar(Pelicula pelicula) {
		
		pelicula.setEstado(this);
	}

	@Override
	public void devolver(Pelicula pelicula) {	
	}

	
	

	
}
