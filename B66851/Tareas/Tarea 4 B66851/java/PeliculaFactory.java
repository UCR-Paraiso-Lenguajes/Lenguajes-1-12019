package com.videocartago.renting.domain;

import java.util.List;

public class PeliculaFactory {

	public Pelicula crearPelicula(
	int codPelicula,
	String titulo,
	int totalPeliculas,
	boolean subtitulada,
	boolean estreno,
	Genero genero,
	List<Actor> actores,
	 String estado
	) {
		
		Pelicula pelicula = new Pelicula();
		pelicula.setCodPelicula(codPelicula);
		pelicula.setTitulo(titulo);
		pelicula.setTotalPeliculas(totalPeliculas);
		pelicula.setSubtitulada(subtitulada);
		pelicula.setEstreno(estreno);
		pelicula.setGenero(genero);
		pelicula.setActores(actores);
		pelicula.setEstado(estado);
		switch(genero.getNombreGenero()) {
		
		case "Terror":
			pelicula.setClasificacion("Mayores de 18 años");
			break;
		case "Suspenso":
			pelicula.setClasificacion("Mayores de 12 años");
			break;	
	    default:
	    	pelicula.setClasificacion("Todo publico");
	    	break;
		}
		return pelicula;
	}
}
