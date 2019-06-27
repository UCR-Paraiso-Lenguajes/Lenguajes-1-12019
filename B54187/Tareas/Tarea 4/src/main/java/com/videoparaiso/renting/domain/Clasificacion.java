package com.videoparaiso.renting.domain;

import java.util.List;

public class Clasificacion extends Pelicula {
	private String clasificacion;

	public Clasificacion(String duracion, String descripcion, int codPelicula, String titulo, int totalPeliculas,
			boolean subtitulada, boolean estreno, Genero genero, List<Actor> actores, String clasificacion, Estado estado) {
		super();
		this.clasificacion = clasificacion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	public void clasificar() {
		Genero genero = getGenero();
		if(genero.getNombreGenero().equals("Terror")) {
			clasificacion = "Mayores de 18.";
		} else if(genero.getNombreGenero().equals("Suspenso")) {
			clasificacion = "Mayores de 12.";
		} else  {
			clasificacion = "Todo Público.";
		}
	}
}
