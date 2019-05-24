package com.orbis.b32915.ventas.domain.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.orbis.b32915.ventas.domain.Autor;

public class LibroForm {

	private int id_libro;
	@NotNull
	private String titulo;
	@NotNull
	private int anno;
	@NotNull
	private int idEditorial;
	@NotNull
	private int isbn;
	@NotNull
	private double precio;
	
	private List listaF;
	
	public LibroForm() {
		
	}	


	@Override
	public String toString() {
		return "LibroForm [titulo=" + titulo + ", anno=" + anno + ", idEditorial=" + idEditorial + ", isbn=" + isbn
				+ ", precio=" + precio + ", listaF=" + listaF + "]";
	}
	
	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List getListaF() {
		return listaF;
	}

	public void setListaF(List listaF) {
		this.listaF = listaF;
	}



	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	

	
	
}
