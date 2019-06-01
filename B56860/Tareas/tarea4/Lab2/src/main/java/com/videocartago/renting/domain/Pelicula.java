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
		setGenero(genero);
		setCodPeliula(codPelicula);
		setTotalPeliculas(totalPeliculas);
		setTitulo(titulo);
		setEstreno(estreno);
		setSubtitulada(subtitulada);
	}
	
	protected abstract void setEstado() ;
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		if(genero == null) throw new RuntimeException("El genero no puede ser vacio");
		this.genero = genero;
	}
	public int getCodPelicula() {
		return codPelicula;
	}
	public void setCodPelicula(int codPelicula) {
		if(codPelicula < 0) throw new RuntimeException("El código no puede ser negativo");
		this.codPelicula = codPelicula;
	}
	public int getTotalPeliculas() {
		return totalPeliculas;
	}
	public void setTotalPeliculas(int totalPeliculas) {
		if(totalPeliculas < 0) throw new RuntimeException("El total de peliclas no puede ser negativo");
		this.totalPeliculas = totalPeliculas;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(estreno) throw new RuntimeException("El titulo no puede ser vacio");
		this.titulo = titulo;
	}
	public boolean isEstreno() {
		return estreno;
	}
	public void setEstreno(boolean estreno) {
		if(estreno == null) throw new RuntimeException("El estreno no puede ser vacio");
		this.estreno = estreno;
	}
	public boolean isSubtitulada() {
		return subtitulada;
	}
	public void setSubtitulada(boolean subtitulada) {
		if(estreno == null) throw new RuntimeException("Debe escoger subtitulación");
		this.subtitulada = subtitulada;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		if(estado == null || estado.trim().equalsIgnoreCase("")) throw new RuntimeException("Debe escoger estado");
		this.estado = estado;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		if(clasificacion == null || clasificacion.trim().equalsIgnoreCase(""))  throw new RuntimeException("Debe escoger clasificación");
		this.clasificacion = clasificacion;
	}
}

	
