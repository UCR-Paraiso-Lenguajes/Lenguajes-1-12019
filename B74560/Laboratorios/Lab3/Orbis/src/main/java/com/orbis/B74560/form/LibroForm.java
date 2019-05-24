package com.orbis.B74560.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibroForm {
	
	@NotNull
	@Size (min=1, max=50)
	private String titulo;
	@NotNull
	@Min (1)
	private int ano;
	@NotNull
	@Min (1)
	private int id_editorial;
	@NotNull
	@Min (1)
	private int id_libro;
	@NotNull
	private String[] autor;
	@NotNull
	@Min (0)
	private float precio;
	
	public LibroForm() {
	}
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String[] getAutor() {
		return autor;
	}

	public void setAutor(String[] autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

}
