package com.videocartago.renting.domain;

import java.util.List;

import com.videocartago.renting.factoryAbstract.PeliculaAbstract;

public class Mayores18Persona extends PeliculaAbstract	  {
	
	public Mayores18Persona(Pelicula pelicula) {
		if(pelicula.equals("")) throw new RuntimeException("La pelicula tiene elementos vacios");
		this.codPelicula =pelicula.getCodPelicula();
		this.titulo = pelicula.getTitulo();
		this.totalPeliculas = pelicula.getTotalPeliculas();
		this.subtitulada = pelicula.isSubtitulada();
		this.estreno = pelicula.isEstreno();
		this.genero= pelicula.getGenero();
		this.actores=pelicula.getActores();
	}
	
	@Override
	public String getTipo() {
		return "Mayores de 18 años";
	}
	@Override
	public void setTipo() {
		this.getTipo();
		
	}
}