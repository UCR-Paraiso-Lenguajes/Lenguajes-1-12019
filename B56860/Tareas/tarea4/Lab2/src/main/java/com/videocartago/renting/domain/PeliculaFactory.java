package com.videocartago.renting.domain;

public class PeliculaFactory {
	
	public void crearPelicula(Pelicula peli) {
		
		switch (peli.getGenero().getNombreGenero()) {
			case "terror":
				peli.setClasificacion("Mayores de 18");
				break;
			case "suspenso":
				peli.setClasificacion("Mayores de 12");
				break;
			default:
				peli.setClasificacion("TP");
		}
	
	}
}