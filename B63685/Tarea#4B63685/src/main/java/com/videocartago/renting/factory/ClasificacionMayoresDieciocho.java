package com.videocartago.renting.factory;

import com.videcartago.renting.domain.Pelicula;

public class ClasificacionMayoresDieciocho extends Clasificacion {

	
	
	private Pelicula pelicula;
	
	 public ClasificacionMayoresDieciocho() {
		
		pelicula= new Pelicula();
	}
	
	@Override
	public String tipoClasificacion() {
		
		return "+18";
	}

	@Override
	public Pelicula getPelicula() {
		
		return pelicula;
	}

	
}
