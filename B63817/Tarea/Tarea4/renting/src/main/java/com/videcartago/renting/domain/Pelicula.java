package com.videcartago.renting.domain;

import java.util.LinkedList;
import java.util.List;

public abstract class Pelicula extends Contenido{
	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	private EstadoPelicula estadoPelicula;


	
	

	
	public Pelicula(String sipnosis) {
		super(sipnosis);
		genero = new Genero();
		actores = new LinkedList<>();
		estadoPelicula= new PeliculaDisponible();
		
	}

	
	
	public Pelicula(String sipnosis, int codPelicula, String titulo, int totalPeliculas, boolean subtitulada,
			boolean estreno, Genero genero, List<Actor> actores) {
		super(sipnosis);
		this.codPelicula = codPelicula;
		this.titulo = titulo;
		this.totalPeliculas = totalPeliculas;
		this.subtitulada = subtitulada;
		this.estreno = estreno;
		this.genero = genero;
		this.actores = actores;
	
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



	public EstadoPelicula getEstadoPelicula() {
		return estadoPelicula;
	}



	public void setEstadoPelicula(EstadoPelicula estadoPelicula) {
		this.estadoPelicula = estadoPelicula;
	}

	

	
	
	
	

}
