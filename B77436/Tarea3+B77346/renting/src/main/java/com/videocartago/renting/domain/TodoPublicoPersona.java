package com.videocartago.renting.domain;

import java.util.List;

import com.videocartago.renting.domain.Pelicula;
import com.videocartago.renting.factoryAbstract.PeliculaAbstract;

public class TodoPublicoPersona extends PeliculaAbstract	  {
	
	public TodoPublicoPersona(Pelicula pelicula) {
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
		return "Todo Publico";
	}

	@Override
	public void setTipo() {
		this.getTipo();
		
	}	

}
