package com.videcartago.renting.domain;

import java.util.List;

public class PeliculaFactory extends Pelicula {

	private PeliculaFactory clasificacion;

	public PeliculaFactory(String duracion, String descripcion, int codPelicula, String titulo, int totalPeliculas,
			boolean subtitulada, boolean estreno, Genero genero, List<Actor> actores) {
		super(duracion, descripcion, codPelicula, titulo, totalPeliculas, subtitulada, estreno, genero, actores);
	}

	public void clasificar() {
		Genero genero = getGenero();
		if(genero.getNombreGenero().equals("Suspenso")) {
			clasificacion=new PeliculaMayor12(getDuracion(), getDescripcion(), getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(), isEstreno(), getGenero(), getActores());
		} else if(genero.getNombreGenero().equals("Terror")) {
			clasificacion=new PeliculaMayor18(getDuracion(), getDescripcion(), getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(), isEstreno(), getGenero(), getActores());
		} else  {
			clasificacion=new PeliculaTodoPublico(getDuracion(), getDescripcion(), getCodPelicula(), getTitulo(), getTotalPeliculas(), isSubtitulada(), isEstreno(), getGenero(), getActores());
		}
	}

	public PeliculaFactory getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(PeliculaFactory clasificacion) {
		this.clasificacion = clasificacion;
	}

}
