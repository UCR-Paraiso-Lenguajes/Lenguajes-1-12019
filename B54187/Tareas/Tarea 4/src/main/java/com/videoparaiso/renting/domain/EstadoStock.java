package com.videoparaiso.renting.domain;

public class EstadoStock implements EstadoPelicula{

	@Override
	public String Estado() {
		return "La película está en stock.";
	}
}
