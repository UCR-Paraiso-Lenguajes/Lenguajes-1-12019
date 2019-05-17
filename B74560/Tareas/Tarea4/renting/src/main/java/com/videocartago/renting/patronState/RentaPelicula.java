package com.videocartago.renting.patronState;

public class RentaPelicula extends EstadoPelicula {

	@Override
	public boolean rentarPelicula() {

		return true;

	}

	@Override
	public boolean devolverPelicula() {

		return false;

	}

}
