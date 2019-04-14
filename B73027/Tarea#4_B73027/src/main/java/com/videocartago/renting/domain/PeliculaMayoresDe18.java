package com.videocartago.renting.domain;


import java.util.List;

import com.videocartago.renting.Factory.PeliculaAbtractTipo;

public class PeliculaMayoresDe18 extends PeliculaAbtractTipo{

	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	private String categoriaEdad;
	
	public PeliculaMayoresDe18(Pelicula pelicula) {
		
		this.codPelicula = pelicula.getCodPelicula();
		this.titulo = pelicula.getTitulo();
		this.totalPeliculas = pelicula.getTotalPeliculas();
		this.subtitulada = pelicula.isSubtitulada();
		this.estreno = pelicula.isEstreno();
		this.genero = pelicula.getGenero();
		this.actores = pelicula.getActores();
		
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
	public String getCategoriaEdad() {
		return categoriaEdad;
	}
	public void setCategoriaEdad() {
		this.categoriaEdad = "Mayores de 18";
	}
	
}