package com.orbis.b73331.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.orbis.b73331.domain.Autor;

public class LibroForm {
	@NotNull
	@Size (min=1, max=50)
	private String titulo;
	@Min (1)
	private int ano;
	private int id_editorial;
	@Min (0)
	private int id_libro;
	@NotNull
	private String[] autoresS;
	@Min (1)
	private float precio;
	
	public LibroForm() {
	}
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String[] getAutoresS() {
		//if(autores==null) {throw new RuntimeException("La lista viene vacia");}
		return autoresS;
	}

	public void setAutoresS(String[] autores) {
		//if(autores==null) {throw new RuntimeException("La lista viene vacia");}
		this.autoresS = autores;
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
