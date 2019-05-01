package com.orbis.b62722.domain;

import java.util.LinkedList;
import java.util.List;

public class Libro {
	
	private int id_libro;
	private String titulo;
	private int ano;
	private float precio;
	private Editorial editorial;
	private List<Autor> autores;
	
	public Libro() {
		autores = new LinkedList<Autor>();
		editorial = new Editorial();
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		if(id_libro <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo == null || titulo.trim().equals("")) throw new RuntimeException("El título es requerido");
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		if(precio <= 0) throw new RuntimeException("El precio debe ser mayor a 0.");
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
}
