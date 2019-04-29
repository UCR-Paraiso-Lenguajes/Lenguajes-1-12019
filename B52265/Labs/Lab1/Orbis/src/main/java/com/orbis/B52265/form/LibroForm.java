package com.orbis.B52265.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class LibroForm {

	@NotNull
	private String titulo;
	@NotNull
	private int ano; 
	@NotNull
	private String publicador;
	@NotNull
	@Size(min=13,max=13)
	private long ISBN;
	@NotNull
	private String nombreAutor;
	@NotNull
	private String apellidosAutor;
	private int idEditorial;
	private int idAutor;
	
	
	
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
	public String getPublicador() {
		return publicador;
	}
	public void setPublicador(String publicador) {
		this.publicador = publicador;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getApellidosAutor() {
		return apellidosAutor;
	}
	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}
	
	
	
}