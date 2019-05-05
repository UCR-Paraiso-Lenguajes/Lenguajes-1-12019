package com.videocartago.renting.patrónState;

public class RentarPelicula extends EstadoPelicula{

	@Override
	public boolean rentarPelicula() {
		
		return true;
	}

	@Override
	public boolean devolverPelicula() {
		
		return false;
	}
	

	

}
