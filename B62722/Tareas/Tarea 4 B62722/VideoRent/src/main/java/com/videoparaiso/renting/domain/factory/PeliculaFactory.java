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

	public PeliculaFactory(int codPelicula, String titulo, int totalPeliculas, boolean subtitulada, boolean estreno,
			Genero genero, List<Actor> actores) {
		super(codPelicula, titulo, totalPeliculas, subtitulada, estreno, genero, actores);
	}

	public void clasificar() {
		Genero genero = getGenero();
		if (genero.getNombreGenero().equalsIgnoreCase("Terror")) {
			clasificacion = new Mayor18(getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(),
					isEstreno(), getGenero(), getActores());
		} else if (genero.getNombreGenero().equalsIgnoreCase("Suspenso")) {
			clasificacion = new Mayor12(getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(),
					isEstreno(), getGenero(), getActores());
		} else {
			clasificacion = new TodoPublico(getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(),
					isEstreno(), getGenero(), getActores());
		}
	}

	public Pelicula getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Pelicula clasificacion) {
		this.clasificacion = clasificacion;
	}
}
