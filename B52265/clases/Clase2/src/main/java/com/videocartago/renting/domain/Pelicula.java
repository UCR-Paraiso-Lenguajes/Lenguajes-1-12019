package com.videocartago.renting.domain;

import java.util.ArrayList;

public class Pelicula {
	private int codPelicula;
	private int totalPeliculas;
	private String titulo;
	private boolean estreno;
	private boolean subTitulada;
	private Genero genero;
	private ArrayList<Actor> actores;

	public int getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(int codPelicula) {
		this.codPelicula = codPelicula;
	}

	public int getTotalPeliculas() {
		return totalPeliculas;
	}

	public void setTotalPeliculas(int totalPeliculas) {
		this.totalPeliculas = totalPeliculas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isEstreno() {
		return estreno;
	}

	public void setEstreno(boolean estreno) {
		this.estreno = estreno;
	}

	public boolean isSubTitulada() {
		return subTitulada;
	}

	public void setSubTitulada(boolean subTitulada) {
		this.subTitulada = subTitulada;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public ArrayList<Actor> getActores() {
		return actores;
	}

	public void setActores(ArrayList<Actor> actores) {
		this.actores = actores;
	}


}
