package com.orbis.B54187.ventas.domain;

public class Libro {

	private int id_libro;
	private String titulo;
	private int ano;
	private float precio;
	private Editorial id_editorial;
	
	public Libro() {
		
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
	public Editorial getId_editorial() {
		return id_editorial;
	}
	public void setId_editorial(Editorial id_editorial) {
		this.id_editorial = id_editorial;
	}
	
}
