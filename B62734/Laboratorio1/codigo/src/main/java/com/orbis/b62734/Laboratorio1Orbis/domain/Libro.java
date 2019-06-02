package com.orbis.b62734.Laboratorio1Orbis.domain;

import java.util.LinkedList;

public class Libro {
	private int idLibro;
	private String titulo;
	private short ano;
	private float precio;
	private LinkedList<Autor> autores;
	
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
	

}
