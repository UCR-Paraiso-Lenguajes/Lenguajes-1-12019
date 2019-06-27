package com.orbis.b53953.domain;

import java.util.ArrayList;
import java.util.List;
import com.orbis.b53953.domain.*;


public class Libro {

	private int idLibro;
	private String titulo;
	private int año;
	private float precio;
	private Editorial editorial;
	private ArrayList<Autor> autores;
	
	
	public Libro() {
		super();
		this.autores = new ArrayList<Autor>();
		
	}


	public Libro(int idLibro, String titulo, int año, float precio, Editorial editorial, ArrayList<Autor> autores) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.año = año;
		this.precio = precio;
		this.editorial = editorial;
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


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public ArrayList<Autor> getAutores() {
		return autores;
	}


	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}


	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", año=" + año + ", precio=" + precio
				+ ", editorial=" + editorial + ", autores=" + autores + "]";
	}


	
	

	
}
