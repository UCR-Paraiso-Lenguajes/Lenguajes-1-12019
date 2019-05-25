package com.videocartago.renting.domain;

import java.util.List;

import com.videocartago.renting.factory.PeliculaTipoAbstracta;

public class PeliculaTP extends PeliculaTipoAbstracta{
	private String tipo;
	
	public PeliculaTP(Pelicula pelicula) {
		this.codPelicula = pelicula.getCodPelicula();
		this.titulo = pelicula.getTitulo();
		this.totalPeliculas = pelicula.getTotalPeliculas();
		this.subtitulada = pelicula.isSubtitulada();
		this.estreno = pelicula.isEstreno();
		this.genero = pelicula.getGenero();
		this.actores = pelicula.getActores();
	}

	public String getTipo() {
		if(tipo==null) throw new RuntimeException("El tipo esta nulo");
		
		return tipo;
	}

	public void setTipo() {
		this.tipo = "Todo publico";
	}
	
}
