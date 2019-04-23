package com.videcartago.renting.domain;

public class Stock extends Estado{

	@Override
	public void devolver(Pelicula pelicula) {
		
		pelicula.setEstado(this);
	}
	
	@Override
	public void rentar(Pelicula pelicula) {	
	}	
}
