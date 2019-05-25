package com.videocartago.renting.factory;

import com.videcartago.renting.domain.Pelicula;

public class ClasificacionMayoresDoce extends Clasificacion {

	
	private Pelicula pelicula;
	
	 public ClasificacionMayoresDoce() {
		
		pelicula= new Pelicula();
	}
	@Override
	public String tipoClasificacion() {
		return "+12";
	}

	@Override
	public Pelicula getPelicula() {
		return pelicula;
	}

}
