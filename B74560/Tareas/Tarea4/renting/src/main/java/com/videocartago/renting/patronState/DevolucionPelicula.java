package com.videocartago.renting.patronState;

public class DevolucionPelicula extends EstadoPelicula {

	@Override
	public boolean rentarPelicula() {

		return false;

	}

	@Override
	public boolean devolverPelicula() {

		return true;

	}

}