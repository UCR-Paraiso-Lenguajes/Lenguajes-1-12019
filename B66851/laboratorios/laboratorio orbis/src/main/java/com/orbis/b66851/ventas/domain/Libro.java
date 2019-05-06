package com.orbis.b66851.ventas.domain;

public class Libro {
	private int id_libro;
	private String titulo;
	private int ano;
	private float precio;
	private Editorial editorial;
	
	
	public Libro() {
		
	}

	public Libro(int id_libro, String titulo, int ano, float precio, Editorial editorial) {
		
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.editorial = editorial;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	

}