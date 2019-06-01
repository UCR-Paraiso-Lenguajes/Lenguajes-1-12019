package com.videocartago.renting.domain;

public class PeliculaFactory {
	
	public Pelicula crearPelicula(Pelicula peli) {
		
		Pelicula pelicula = new Pelicula(peli.getGenero(), peli.getCodPelicula(), peli.getTotalPeliculas(),peli.getTitulo, peli.getEstreno(),
			peli.isSubtitulada());
		
		switch (peli.getGenero().getNombreGenero()) {
			case "terror":
				pelicula.setClasificacion("Mayores de 18");
				break;
			case "suspenso":
				pelicula.setClasificacion("Mayores de 12");
				break;
			default:
				pelicula.setClasificacion("TP");
		}
		
		return pelicula;
	}
}
