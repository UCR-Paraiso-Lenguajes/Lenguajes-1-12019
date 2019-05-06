package com.videocartago.renting.patrónState;

public class DevolverPelicula extends EstadoPelicula{

	@Override
	public boolean rentarPelicula() {
		
		return false;
	}

	@Override
	public boolean devolverPelicula() {
		
		return true;
	}

}
