package com.orbis.b53953.data;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.orbis.b53953.domain.Autor;

public class LibroForm {

	private int idLibro;
	@NotNull
	private String titulo;
	@NotNull
	@Min(2)
	private int año;
	private float precio;
	private int idEditorial;
	private int[] autores;
	
	
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

	public int[] getAutores() {
		return autores;
	}

	public void setAutores(int[] autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "LibroForm [idLibro=" + idLibro + ", titulo=" + titulo + ", año=" + año + ", precio=" + precio
				+ ", idEditorial=" + idEditorial + ", autores=" + Arrays.toString(autores) + "]";
	}

	

	
	
	
}
