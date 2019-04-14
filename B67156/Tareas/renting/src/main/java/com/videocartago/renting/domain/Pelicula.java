package com.videocartago.renting.domain;

import java.util.LinkedList;
import java.util.List;

public class Pelicula implements PeliculaAbstract{
	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private String categoria;
	private String estado;
	private List<Actor> actores;
	
	public Pelicula() {
		genero = new Genero();
		actores = new LinkedList<>();
	}
	
	
	
	public Pelicula(int codPelicula, String titulo, int totalPeliculas, boolean subtitulada, boolean estreno,
			Genero genero, String categoria, String estado) {
		super();
		this.codPelicula = codPelicula;
		this.titulo = titulo;
		this.totalPeliculas = totalPeliculas;
		this.subtitulada = subtitulada;
		this.estreno = estreno;
		this.genero = genero;
		this.categoria = categoria;
		this.estado = estado;
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
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pelicula [codPelicula=" + codPelicula + ", titulo=" + titulo + ", totalPeliculas=" + totalPeliculas
				+ ", subtitulada=" + subtitulada + ", estreno=" + estreno + ", genero=" + genero + ", categoria="
				+ categoria + ", estado=" + estado + ", actores=" + actores + "]";
	}
	
	
}
