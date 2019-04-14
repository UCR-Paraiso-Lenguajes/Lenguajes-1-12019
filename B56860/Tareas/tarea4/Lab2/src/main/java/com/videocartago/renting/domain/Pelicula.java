package com.videocartago.renting.domain;

public abstract class Pelicula {
	
	private Genero genero;
	private int codPelicula;
	private int totalPeliculas;
	private String titulo;
	private boolean estreno;
	private boolean subtitulada;
	private String clasificacion;
	private String estado;
	
	public Pelicula() {
		
	}
	
	public Pelicula(Genero genero, int codPelicula, int totalPeliculas, String titulo, boolean estreno,
			boolean subtitulada) {
		this.genero = genero;
		this.codPelicula = codPelicula;
		this.totalPeliculas = totalPeliculas;
		this.titulo = titulo;
		this.estreno = estreno;
		this.subtitulada = subtitulada;
	}
	
	protected abstract void setEstado() ;
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
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
	public boolean isSubtitulada() {
		return subtitulada;
	}
	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada = subtitulada;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
}

	