package com.videcartago.renting.domain.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PeliculaForm 
{
	private int codPelicula;
	@NotNull
	@Size(min=2, max=50)
	private String titulo;
	@NotNull
	@Min(2)
	private int totalPeliculas;
	private boolean subtitulada;
	private boolean estreno;
	@NotNull
	private int codGenero;
	
	public PeliculaForm() {
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

	public int getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(int codGenero) {
		this.codGenero = codGenero;
	}
	
	
}