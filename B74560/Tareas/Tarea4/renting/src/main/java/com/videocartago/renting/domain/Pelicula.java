package com.videocartago.renting.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.videocartago.renting.exception.RentingException;
import com.videocartago.renting.patronState.EstadoPelicula;

public class Pelicula {

	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;

	public Pelicula() {
		genero = new Genero();
		actores = new LinkedList<>();
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

	public void setRentar(EstadoPelicula estadoPelicula) {

		if (!estadoPelicula.rentarPelicula()) {
			throw new RentingException("No es posible rentar la pelicula");
		} else {
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Pelicula fue rentada con exito");
		}

	}

	public void setDevolver(EstadoPelicula estadoPelicula) {

		if (!estadoPelicula.devolverPelicula()) {
			throw new RentingException("No es posible devolver la pelicula");
		} else {
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Pelicula fue devuelta con exito");
		}

	}

}