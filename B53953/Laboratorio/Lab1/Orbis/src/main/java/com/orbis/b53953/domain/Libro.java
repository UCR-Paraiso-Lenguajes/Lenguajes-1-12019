package com.orbis.b53953.domain;

public class Libro {

	private int idLibro;
	private String titulo;
	private int año;
	private float precio;
	private int idEditorial;
	
	
	public Libro(int idLibro, String titulo, int año, float precio, int idEditorial) {
		super();
		
		
		if(idLibro <= 100) throw new RuntimeException("El idLibro debe ser mayor a 100");
		if(titulo == null || titulo.trim().equals("")) throw new RuntimeException("El titulo del libro es requerido");	
		if(año <= 0) throw new RuntimeException("El año debe ser mayor a 0");
		if(precio <= 0) throw new RuntimeException("El precio debe ser mayor a 0");
		if(idEditorial <= 100) throw new RuntimeException("El precio debe ser mayor a 100");
		
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.año = año;
		this.precio = precio;
		this.idEditorial = idEditorial;
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


	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", año=" + año + ", precio=" + precio
				+ ", idEditorial=" + idEditorial + "]";
	}
	
	
	
	
}
