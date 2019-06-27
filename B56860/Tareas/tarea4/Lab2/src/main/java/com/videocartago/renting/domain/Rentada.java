package com.videocartago.renting.domain;


public class Rentada extends Pelicula {

	
	@Override
	protected void setEstado() {
		if(getEstado().equals("enStock"))
			setEstado("enStock");
		else
			throw new RuntimeException("La película no puede ser devuelta si ya esta en stock");
	}
	
	public void Devolver() {
		setEstado();
	}

	
	
}
