package com.videocartago.renting.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pelicula {

	private int codPelicula;
	private String titulo;
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	private Genero genero;
	private List<Actor> actores;
	private String tipoPublico;
	private String estado; //en stock o rentada
	
	private Iterator<Movimiento> movimientos;
	
	public Pelicula() {
		genero=new Genero();
		actores=new ArrayList<>();
	}
	
	public Pelicula(int codPelicula, Iterator<Movimiento> movimientos) {
		super();
		this.codPelicula = codPelicula;
		this.movimientos = movimientos;
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
	public String getTipoPublico() {
		return tipoPublico;
	}
	public void setTipoPublico(String tipoPublico) {
		this.tipoPublico = tipoPublico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	


}
