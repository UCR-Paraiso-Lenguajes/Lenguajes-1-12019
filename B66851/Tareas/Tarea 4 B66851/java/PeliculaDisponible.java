package com.videocartago.renting.domain;

public class PeliculaDisponible implements State{

	@Override
	public String cambiarEstado() {
		return "Disponible";
	}
}
