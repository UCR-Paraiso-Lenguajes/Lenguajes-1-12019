package com.orbis.b73027.domain;

public class Libro {
	private int id_libro;
	private String titulo;
	private short ano;
	private float precio;
	private int id_editorial;
	
	public Libro() {
		
	}
	
	public Libro(int id_libro, String titulo, short ano, float precio, int id_editorial) {
		if(id_libro ==0 || id_editorial==0 || ano==0 || precio==0) throw new RuntimeException("Se encuentran datos sin llenar");
		if(titulo.equals(""))throw new RuntimeException("Se encuentran datos sin completar");
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.ano = ano;
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
	public short getAno() {
		return ano;
	}
	public void setAno(short ano) {
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
