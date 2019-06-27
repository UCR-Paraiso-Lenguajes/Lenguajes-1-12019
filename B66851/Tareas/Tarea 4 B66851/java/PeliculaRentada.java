package com.videocartago.renting.domain;

public class PeliculaRentada implements State{

	@Override
	public String cambiarEstado() {
		return "Rentada";
	}
}
