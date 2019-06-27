package com.videoparaiso.renting.domain;

public class EstadoRentada implements EstadoPelicula{
	
	@Override
	public String Estado() {
		return "Rentada con éxito.";
	}
}