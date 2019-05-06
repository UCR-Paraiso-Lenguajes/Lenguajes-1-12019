package com.videocartago.renting.domain;

import java.util.List;

public class Pelicula {

	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	private boolean subtitulada;
	
	public Pelicula() {
		
	}

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTotalPeliculas() {
		return totalPeliculas;
	}

	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas = totalPeliculas;
	}

	public boolean isEstreno() {
		return estreno;
	}

	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	public boolean isSubtitulada() {
		return subtitulada;
	}

	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada = subtitulada;
	}

	
}
