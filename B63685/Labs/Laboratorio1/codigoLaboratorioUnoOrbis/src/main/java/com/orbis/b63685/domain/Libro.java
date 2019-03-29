package com.orbis.b63685.domain;

import java.util.ArrayList;

public class Libro {
	
	private int idLibro;
	private Editorial editorial;
	private ArrayList<Autor> autores;
	private String titulo;
	private short ano;
	private float precio;

	public Libro(int idLibro, Editorial editorial, ArrayList<Autor> autores, String titulo, short ano, float precio) {
		super();
		this.idLibro = idLibro;
		this.editorial = editorial;
		this.autores = autores;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
	}


	public Libro() {
		// TODO Auto-generated constructor stub
	}


	public int getIdLibro() {
		return idLibro;
	}


	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
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
	
	
	

}
