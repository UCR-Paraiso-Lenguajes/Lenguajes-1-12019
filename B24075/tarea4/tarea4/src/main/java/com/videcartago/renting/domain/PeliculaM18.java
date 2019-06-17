package com.videcartago.renting.domain;

import com.videcartago.renting.inter.IPelicula;

public class PeliculaM18 implements IPelicula{
	
	private String estado;
	
	public PeliculaM18() {
		
	}


@Override
public void rentar() {
	if(this.estado.equalsIgnoreCase("en strock") )		this.estado="rentada";

	
}

@Override
public void devolver() {
	if(this.estado.equalsIgnoreCase("rentada") )		this.estado="en strock";
	
}

}
