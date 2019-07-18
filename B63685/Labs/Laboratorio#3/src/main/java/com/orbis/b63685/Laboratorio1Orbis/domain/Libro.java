package com.orbis.b63685.Laboratorio1Orbis.domain;

import java.util.LinkedList;

public class Libro {
	private int idLibro;
	private String titulo;
	private short ano;
	private float precio;
	private LinkedList<Autor> autores;
	private Editorial editorial;
	

	public Libro() {
		super();
		autores=new LinkedList<Autor>();
		editorial=new Editorial();
	}
	
	public Libro(int idLibro, String titulo, short ano, float precio, LinkedList<Autor> autores, Editorial editorial) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.autores = autores;
		this.editorial = editorial;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int id_libro) {
		this.idLibro = id_libro;
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
	public LinkedList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(LinkedList<Autor> autores) {
		this.autores = autores;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", ano=" + ano + ", precio=" + precio + ", autores="
				+ autores + ", editorial=" + editorial + "]";
	}
	

}
