package com.videcartago.renting.domain;

public class PeliculaRentada implements EstadoPelicula{

	@Override
	public String estado() {
		return "Rentada";
	}

}
