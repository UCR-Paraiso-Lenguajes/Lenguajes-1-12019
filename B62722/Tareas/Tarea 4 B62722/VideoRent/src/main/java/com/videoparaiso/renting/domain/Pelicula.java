package com.videoparaiso.renting.domain;

import java.util.LinkedList;

import java.util.List;

public class Pelicula extends Contenido  {

	 private int codPelicula;
	 private String titulo;
	 private int totalPeliculas;
	 private boolean subtitulada;
	 private boolean estreno;
	 private Genero genero;
	 private List<Actor> actores;
	 private EstadoPelicula estado;

	 public Pelicula(int codPelicula, String titulo, int totalPeliculas,
	   boolean subtitulada, boolean estreno, Genero genero, List<Actor> actores) {
		super();
		this.codPelicula = codPelicula;
		this.titulo = titulo;
		this.totalPeliculas = totalPeliculas;
		this.subtitulada = subtitulada;
		this.estreno = estreno;
		this.genero = genero;
		this.actores = actores;
	}

	public Pelicula() {
		genero = new Genero();
		actores = new LinkedList<Actor>();
		estado = new Disponible();
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

	public EstadoPelicula getEstado() {
		return estado;
	}

	public void setEstado(EstadoPelicula estado) {
		this.estado = estado;
	}
	
	public void estado() {
		estado.Estado();
	}

}
