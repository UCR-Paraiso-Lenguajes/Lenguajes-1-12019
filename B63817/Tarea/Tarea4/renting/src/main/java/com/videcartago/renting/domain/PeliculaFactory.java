package com.videcartago.renting.domain;

import java.util.List;

public abstract class PeliculaFactory extends Pelicula{

	private String calificación;
	
	public PeliculaFactory(String sipnosis, int codPelicula, String titulo, int totalPeliculas, boolean subtitulada,
			boolean estreno, Genero genero, List<Actor> actores) {
		super(sipnosis, codPelicula, titulo, totalPeliculas, subtitulada, estreno, genero, actores);

	if(genero.getNombreGenero().equalsIgnoreCase("Terror")) {
			this.calificación="Mayores de 18 años";
			
		} else if(genero.getNombreGenero().equalsIgnoreCase("Suspenso")){
			
			this.calificación="Mayores de 12 años";
		}else {
			this.calificación="Todo publico";
			
		}
	}
	public String getCalificación() {
		return calificación;
	}
	public void setCalificación(String calificación) {
		this.calificación = calificación;
	}
	
	
	
	

	
}
