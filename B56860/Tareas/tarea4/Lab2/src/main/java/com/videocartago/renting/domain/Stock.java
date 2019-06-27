package com.videocartago.renting.domain;

public class Stock extends Pelicula {
	
	
	public Stock() {
		
	}
	
	
	@Override
	protected void setEstado() {
		if(getEstado().equals("rentada"))
			setEstado("rentada");
		else
			throw new RuntimeException("La película no puede ser rentada si ya esta en renta");
	}


	public void rentar() {
		setEstado();
	}

}
