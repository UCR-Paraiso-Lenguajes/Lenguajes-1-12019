package com.videocartago.renting.factoryAbstract;

import java.util.List;

import com.videocartago.renting.domain.Actor;
import com.videocartago.renting.domain.Genero;

public abstract class PeliculaAbstract {
	
	public int codPelicula;
	public String titulo;
	public int totalPeliculas;
	public boolean subtitulada;
	public boolean estreno;
	public Genero genero;
	public List<Actor> actores;
	
	
	public abstract void setTipo();
	public abstract String getTipo();
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero=genero;
	}
	public List<Actor> getActores() {
		return actores;
	}
	public void setActores(List<Actor> actores) {
		this.actores=actores;
	}
	public int getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(int codPelicula) {
		this.codPelicula=codPelicula;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	public int getTotalPeliculas() {
		return totalPeliculas;
	}
	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas=totalPeliculas;
	}
	public boolean isSubtitulada() {
		return subtitulada;
	}
	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada=subtitulada;
	}
	public boolean isEstreno() {
		return estreno;
	}
	public void setEstreno(boolean estreno) {
		this.estreno=estreno;
	}	

}
