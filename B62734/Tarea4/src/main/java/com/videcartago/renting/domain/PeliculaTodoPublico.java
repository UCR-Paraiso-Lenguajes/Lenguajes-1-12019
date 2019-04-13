package com.videcartago.renting.domain;

import java.util.List;

public class PeliculaTodoPublico extends PeliculaFactory {

	public PeliculaTodoPublico(String duracion, String descripcion, int codPelicula, String titulo, int totalPeliculas,
			boolean subtitulada, boolean estreno, Genero genero, List<Actor> actores) {
		super(duracion, descripcion, codPelicula, titulo, totalPeliculas, subtitulada, estreno, genero, actores);
		// TODO Auto-generated constructor stub
	}

}
