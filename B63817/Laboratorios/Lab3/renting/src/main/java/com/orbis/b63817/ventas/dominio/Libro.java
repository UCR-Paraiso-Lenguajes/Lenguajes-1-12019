package com.orbis.b63817.ventas.dominio;

public class Libro {
	
	private int id_libro;
	private String titulo;
	private int ano;
	private float precio;
	private int id_editorial;
	
	
	
	public Libro(int id_libro, String titulo, short ano, float precio,int id_editorial) {
		super();
		if(id_libro < 0) throw new RuntimeException("El id debe ser mayor a 0.");
		if(titulo == null || titulo.trim().equals("")) throw new RuntimeException("El titulo es requerido");
		if(ano <=0) throw new RuntimeException("El año debe ser mayor a 0.");
		if(precio <=0) throw new RuntimeException("El año debe ser mayor a 0.");
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.id_editorial=id_editorial;
	}

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

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}
	
	

}
