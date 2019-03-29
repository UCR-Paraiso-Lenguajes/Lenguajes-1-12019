package com.orbis.b63199.dominio;

import java.util.ArrayList;

public class Libro {

	private int id_libro;
	private String titulo;
	private double ano;
	private double precio;
	private ArrayList<Autor> autores;
	
	
	
	public Libro() {
		super();
	}

	public Libro(int id_libro, String titulo, double ano, double precio, ArrayList<Autor> autores) {
		if(id_libro<0) throw new RuntimeException("Id no valida");
		this.id_libro = id_libro;
		if(titulo!=null)  throw new RuntimeException("direccion no valido");
		this.titulo = titulo;
		if(ano>0)  throw new RuntimeException("direccion no valido");
		this.ano = ano;
		if(precio>0)  throw new RuntimeException("direccion no valido");
		this.precio = precio;
		if(autores!=null)  throw new RuntimeException("direccion no valido");
		this.autores = autores;
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

	public double getAno() {
		return ano;
	}

	public void setAno(double ano) {
		this.ano = ano;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
	
	
}
