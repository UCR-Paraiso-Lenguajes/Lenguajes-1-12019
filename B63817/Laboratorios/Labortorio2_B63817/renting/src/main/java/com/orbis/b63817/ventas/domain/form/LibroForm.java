package com.orbis.b63817.ventas.domain.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.orbis.b63817.ventas.dominio.Autor;

public class LibroForm 
{
	@NotNull
	private int isbn;
	@NotNull
	@Size(min=2, max=50)
	private String titulo;
	@NotNull
	private int ano;
	@NotNull
	private int id_Editorial;
	
	@NotNull
	private int precio;
	private List listaAutoresDelLibro;
	
	
	public LibroForm() {
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	public int getId_Editorial() {
		return id_Editorial;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setId_Editorial(int id_Editorial) {
		this.id_Editorial = id_Editorial;
	}
	
	public List getListaAutoresDelLibro() {
		return listaAutoresDelLibro;
	}
	public void setListaAutoresDelLibro(List listaAutoresDelLibro) {
		this.listaAutoresDelLibro = listaAutoresDelLibro;
	}
	
	@Override
	public String toString() {
		return "LibroForm [isbn=" + isbn + ", titulo=" + titulo + ", ano=" + ano + ", id_Editorial=" + id_Editorial
				+ ", precio=" + precio + ", listaAutoresDelLibro=" + listaAutoresDelLibro + "]";
	}
	
	

	
	
	
}