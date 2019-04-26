package com.videocartago.renting.domain;

public class Productora {
	
	private static Productora instance = new Productora();
	
	private Productora() {
		
	}
	
	public static Productora getInstance() {
		return instance;
	}
	
	public Pelicula crearPelicula() {
		return null;
	}
}
