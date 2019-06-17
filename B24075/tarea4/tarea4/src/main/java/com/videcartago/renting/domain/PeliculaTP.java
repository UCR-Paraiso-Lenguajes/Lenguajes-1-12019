package com.videcartago.renting.domain;

import com.videcartago.renting.inter.IPelicula;

public class PeliculaTP implements IPelicula{
	
	private  String estado;
	
	 public PeliculaTP() {
		// TODO Auto-generated constructor stub
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
