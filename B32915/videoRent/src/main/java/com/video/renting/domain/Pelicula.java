package com.video.renting.domain;

import java.util.List;

public class Pelicula {

	private int codPelicula;
	private String titulo;
	private int totalPelicula;
	private boolean subtitulada;
	private boolean estreno;
	private boolean disponibilidad;
	private Genero genero;
	private String clasificacion;
	private List<Actor> actores;
	
	public Pelicula() {
		
	}
	
    public Pelicula(int codPelicula, String titulo, int totalPelicula, boolean subtitulada, 
			boolean estreno, boolean disponibilidad,
			Genero genero, String clasificacion, List<Actor> actores) {
		
		this.codPelicula = codPelicula;
		this.titulo = titulo;
		this.totalPelicula = totalPelicula;
		this.subtitulada = subtitulada;
		this.estreno = estreno;
		this.disponibilidad = disponibilidad;
		this.genero = genero;
		
		if(this.genero.getNombreGenero().equalsIgnoreCase("Terror")) {

			this.clasificacion = "Mayores de 18 años";
			
		}else if(this.genero.getNombreGenero().equalsIgnoreCase("Suspenso")) {
			
			this.clasificacion = "Mayores de 12 años";
			
		}else if(!this.genero.getNombreGenero().equalsIgnoreCase("Suspenso") && 
				!this.genero.getNombreGenero().equalsIgnoreCase("Terro")) {
			this.clasificacion = "Todo publico";	
		}
		
		this.actores = actores;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
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
	public int getTotalPelicula() {
		return totalPelicula;
	}
	public void setTotalPelicula(int totalPelicula) {
		this.totalPelicula = totalPelicula;
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
	
	

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Pelicula [codPelicula=" + codPelicula + ", titulo=" + titulo + ", totalPelicula=" + totalPelicula
				+ ", subtitulada=" + subtitulada + ", estreno=" + estreno + ", genero=" + genero + ", actores="
				+ actores + "]";
	}
	
}
