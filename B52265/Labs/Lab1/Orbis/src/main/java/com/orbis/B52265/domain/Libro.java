package com.orbis.B52265.domain;

import java.util.ArrayList;

public class Libro {
	private int idLibro;
	private String titulo;
	private short ano;
	private float precio;
	private ArrayList<Autor> autores;

	public Libro(int idLibro, String titulo, short ano, float precio, ArrayList<Autor> autores) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.autores = autores;
	}

	public Libro() {
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
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

	public boolean existeLibro() {
		return false;
	}

	public boolean validaCampoIsEmpty() {
		return false;
	}

	public boolean validaCampoSize() {
		return false;
	}

	public boolean validaCaracteres() {
		return false;
	}

	public boolean validaNumerico() {
		return false;
	}

	public boolean validaPrecio() {
		return false;
	}

	public boolean validaFechaActual() {
		return false;
	}

	public Editorial getEditorial() {
		// TODO Auto-generated method stub
		return null;
	}
}
