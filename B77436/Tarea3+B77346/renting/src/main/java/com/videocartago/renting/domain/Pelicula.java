package com.videocartago.renting.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.videocartago.renting.comportamiento.state.EstadoPeliculas;

public class Pelicula {
	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	
	private String estadoPelicula;
	
	public Pelicula() {
		genero = new Genero();
		actores = new LinkedList<>();
	}
	
	public void setEstadoRentado(EstadoPeliculas estadoPelicula) {
		if(!estadoPelicula.rentar()) {
			throw new RuntimeException("La pelicula no se puede rentar");
		}else {
			Logger.getLogger(getClass().getName()).log(
		            Level.INFO, "Pelicula rentada");
		}
	}
	
	public void setEstadoDevuelto(EstadoPeliculas estadoPelicula) {
		if(!estadoPelicula.devolver()) {
			throw new RuntimeException("La pelicula no se puede devolver");
		}else {
			Logger.getLogger(getClass().getName()).log(
		            Level.INFO, "Pelicula devuelta");
		}
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
	

}