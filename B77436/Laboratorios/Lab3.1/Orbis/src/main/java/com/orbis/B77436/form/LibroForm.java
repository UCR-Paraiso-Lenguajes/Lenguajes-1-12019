package com.orbis.B77436.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibroForm {
	@NotNull
	@Size (min=2, max=50)
	private String titulo;
	@NotNull
	@Min(999)
	private short año;
	@NotNull
	@Min((long) 2.0)
	private float precio;
	@NotNull
	private int publicador;
	@NotNull
	@Min(1)
	private String isbn;
	@NotNull
	private List<String> autores;
	
	

	public LibroForm() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public short getAño() {
		return año;
	}

	public void setAño(short año) {
		this.año = año;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getPublicador() {
		return publicador;
	}

	public void setPublicador(int publicador) {
		this.publicador = publicador;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	
	

}
