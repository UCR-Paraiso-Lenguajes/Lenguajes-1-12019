package com.orbis.b54524.datos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LibroForm {

	private int idLibro;
	@NotNull
	private String titulo;
	@NotNull
	@Min(2)
	private int año;
	private float precio;
	private int idEditorial;
	
	public LibroForm() {
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
}
