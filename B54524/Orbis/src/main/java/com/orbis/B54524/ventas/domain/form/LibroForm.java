package com.orbis.B54524.ventas.domain.form;

import java.util.ArrayList;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibroForm {

	private int id;
	@NotNull
	@Size(min = 1, max = 30)
	private String titulo;

	@Max(2019)
	@Min(1)
	private int anio;

	@Min(0)
	private double precio;

	@Min(1)
	private int idEditorial;

	@NotNull
	@Size(min = 1)
	private ArrayList<Integer> idAutores;

	public LibroForm() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public ArrayList<Integer> getIdAutores() {
		return idAutores;
	}

	public void setIdAutores(ArrayList<Integer> autores) {
		this.idAutores = autores;
	}
}
