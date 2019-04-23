package com.videocartago.renting.domain;

import java.util.List;

import com.videocartago.renting.factory.PeliculaTipoAbstracta;

public class PeliculaMayores12 extends PeliculaTipoAbstracta{
	

	private String tipo;
	public PeliculaMayores12(Pelicula pelicula) {
		this.codPelicula = pelicula.getCodPelicula();
		this.titulo = pelicula.getTitulo();
		this.totalPeliculas = pelicula.getTotalPeliculas();
		this.subtitulada = pelicula.isSubtitulada();
		this.estreno = pelicula.isEstreno();
		this.genero = pelicula.getGenero();
		this.actores = pelicula.getActores();
	}

	public void setTipo() {
		this.tipo = "Mayores de 12";
	}
	public String getTipo() {
		if(tipo==null) throw new RuntimeException("El tipo esta nulo");
		
		return tipo;
	}
	

	
	
	
}

