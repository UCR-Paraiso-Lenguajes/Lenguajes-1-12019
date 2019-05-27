package com.orbis.B76223.ventas.form;



import java.util.Calendar;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibroForm {

	@Size(min=1, max=50)
	private String titulo;

	@Min(1)
	@Max(2019)
	private int ano;

	@Max(1999999999)
	private long ISBN;

	@Min(1)
	private int idEditorial;

	@NotNull
	private String[] idAutor;
	
	@Min(1)
	private float precio;

	public LibroForm() {
		
	}
	
	public void setIdAutor(String[] idAutor) {
		this.idAutor = idAutor;
		
	}

	public String[] getIdAutor() {
		return idAutor;
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

	
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	
}
