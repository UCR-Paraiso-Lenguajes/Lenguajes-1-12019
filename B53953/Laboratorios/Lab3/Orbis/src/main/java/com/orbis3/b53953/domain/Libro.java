package com.orbis3.b53953.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Libro {
	private int id;
	private String titulo;
	private int anio;
	private double precio;
	private Editorial editorial;
	private ArrayList<Autor> autores;

	public Libro(int id, String titulo, int anio, double precio, Editorial editorial, ArrayList<Autor> autores) {
		setId(id);
		setTitulo(titulo);
		setAnio(anio);
		setPrecio(precio);
		setEditorial(editorial);
		setAutores(autores);
	}

	public Libro() {
		id = 0;
		titulo = "";
		anio = 0;
		precio = 0;
		editorial = new Editorial();
		autores = new ArrayList<>();
	}

	public boolean fechaValida(int fecha) {
		return anio < 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0)
			throw new RuntimeException("El id no puede ser negativo!");
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == null || titulo.trim().equals(""))
			throw new RuntimeException("El titulo no es valido!");
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		if (anio < 0)
			throw new RuntimeException("El año no es valido!");
		this.anio = anio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio < 0)
			throw new RuntimeException("El precio no es valido!");
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		if (editorial == null)
			throw new NullPointerException("La editorial no puede ser nula!");
		this.editorial = editorial;
	}

	public Iterator<Autor> getAutores() {
		return autores.iterator();
	}

	public void setAutores(ArrayList<Autor> autores) {
		if (autores == null)
			throw new NullPointerException("La lista de autores esta nula!");
		this.autores = autores;
	}

}