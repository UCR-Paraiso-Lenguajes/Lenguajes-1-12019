package com.videoparaiso.renting.domain.factory;

import java.util.List;

import com.videoparaiso.renting.domain.Actor;
import com.videoparaiso.renting.domain.Genero;
import com.videoparaiso.renting.domain.Pelicula;

import com.videoparaiso.renting.domain.factory.Mayor12;
import com.videoparaiso.renting.domain.factory.Mayor18;
import com.videoparaiso.renting.domain.factory.TodoPublico;

public class PeliculaFactory extends Pelicula {

	private Pelicula clasificacion;

	public PeliculaFactory() {
		super();
	}

	public Pelicula clasificar(int codPelicula, String titulo, int totalPeliculas, boolean subtitulada, boolean estreno,
			Genero genero, List<Actor> actores) {
		if (genero.getNombreGenero().equalsIgnoreCase("Terror")) {
			return clasificacion = new Mayor18(getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(),
					isEstreno(), getGenero(), getActores());
		} else if (genero.getNombreGenero().equalsIgnoreCase("Suspenso")) {
			return clasificacion = new Mayor12(getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(),
					isEstreno(), getGenero(), getActores());
		} else {
			return clasificacion = new TodoPublico(getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(),
					isEstreno(), getGenero(), getActores());
		}
	}

}
