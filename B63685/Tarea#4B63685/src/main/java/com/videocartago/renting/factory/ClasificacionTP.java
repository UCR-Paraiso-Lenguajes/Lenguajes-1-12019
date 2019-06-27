package com.videocartago.renting.factory;

import com.videcartago.renting.domain.Pelicula;

public class ClasificacionTP extends Clasificacion {

	
	private Pelicula pelicula;
	
	public ClasificacionTP() {

	pelicula = new Pelicula();
	}
	
	@Override
	public String tipoClasificacion() {
		
		return "TP";
	}

	@Override
	public Pelicula getPelicula() {
		
		return pelicula;
	}

}
