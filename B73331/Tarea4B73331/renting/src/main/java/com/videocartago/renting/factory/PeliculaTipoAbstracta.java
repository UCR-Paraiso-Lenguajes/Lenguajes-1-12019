package com.videocartago.renting.factory;

import java.util.List;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;

public abstract class PeliculaTipoAbstracta {
	public int codPelicula;
	public String titulo;
	public int totalPeliculas;
	public boolean subtitulada;
	public boolean estreno;
	public Genero genero;
	public List<Actor> actores;
	private String tipo;
	public abstract void setTipo();
	public abstract String getTipo();
	public Genero getGenero() {
		if(genero==null) throw new RuntimeException("El genero esta nulo");
		
		return genero;
	}

	public void setGenero(Genero genero) {
		if(genero==null) throw new RuntimeException("El genero no puede ser nulo");
		this.genero = genero;
	}

	public List<Actor> getActores() {
		if(actores==null) throw new RuntimeException("La lista de actores esta nula");
		return actores;
	}

	public void setActores(List<Actor> actores) {
		if(actores==null||actores.size()==0) throw new RuntimeException("El genero no puede ser nulo");
		this.actores = actores;
	}

	public int getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}
	public String getTitulo() {
		if(titulo==""||titulo==null) throw new RuntimeException("El titulo esta nulo o el titulo esta vacio");
		
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(titulo==""||titulo==null) throw new RuntimeException("El titulo esta nulo o el titulo esta vacio");
		
		this.titulo = titulo;
	}
	public int getTotalPeliculas() {
		return totalPeliculas;
	}
	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas = totalPeliculas;
	}
	public boolean isSubtitulada() {
		return subtitulada;
	}
	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada = subtitulada;
	}
	public boolean isEstreno() {
		return estreno;
	}
	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}
}
