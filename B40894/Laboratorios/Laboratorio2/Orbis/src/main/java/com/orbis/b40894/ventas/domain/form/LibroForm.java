package com.orbis.b40894.ventas.domain.form;

import java.util.List;

import javax.validation.constraints.NotNull;

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
	
	private List listaFinal;
	
	public LibroForm() {
		
	}	


	@Override
	public String toString() {
		return "LibroForm [titulo=" + titulo + ", anno=" + anno + ", idEditorial=" + idEditorial + ", isbn=" + isbn
				+ ", precio=" + precio + ", listaFinal=" + listaFinal + "]";
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

	public List getListaFinal() {
		return listaFinal;
	}

	public void setListaFinal(List listaFinal) {
		this.listaFinal = listaFinal;
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
