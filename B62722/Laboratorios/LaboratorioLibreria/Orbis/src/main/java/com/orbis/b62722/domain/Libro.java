package com.orbis.b62722.domain;

import java.util.Calendar;

public class Libro {
	
	private int id_libro;
	private String titulo;
	private int año;
	private float precio;
	private int id_editorial;
	
	public Libro(int id_libro, String titulo, int año, int precio, int id_editorial) {
		Calendar fechaActual = Calendar.getInstance();
		
		if(id_libro <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		if(titulo == null || titulo.trim().equals("")) throw new RuntimeException("El título es requerido");
		if(año >= fechaActual.YEAR) throw new RuntimeException("La fecha es incorrecta.");
		if(precio <= 0) throw new RuntimeException("El precio debe ser mayor a 0.");
		if(id_editorial <= 0) throw new RuntimeException("El id debe ser mayor a 0.");
		
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.año = año;
		this.precio = precio;
		this.id_editorial = id_editorial;
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
	
	public int getId_editorial() {
		return id_editorial;
	}
	
	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}
	
	

}
