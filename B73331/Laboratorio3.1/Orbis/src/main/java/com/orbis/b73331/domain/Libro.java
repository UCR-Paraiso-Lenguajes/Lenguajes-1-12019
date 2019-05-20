package com.orbis.b73331.domain;

import java.util.List;

public class Libro {
	private int id_libro;
	private String titulo;
	private short ano;
	private float precio;
	private int id_editorial;
	public Libro(int id_libro, String titulo, short ano, float precio, int id_editorial) {
		if(id_libro ==0 || id_editorial==0 || ano==0 || precio==0) throw new OrbisExcepcion("Se encuentran datos sin llenar");
		if(titulo.equals(""))throw new OrbisExcepcion("Se encuentran datos sin completar");
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.id_editorial = id_editorial;
	}
	
	public Libro() {
	}

	public int getId_libro() {
		if(id_libro == 0) throw new OrbisExcepcion("El id_libro viene vacio");
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		if(id_libro == 0) throw new OrbisExcepcion("El id_libro viene vacio");
		this.id_libro = id_libro;
	}
	public String getTitulo() {
		if(titulo.equals("") || titulo==null) throw new OrbisExcepcion("El titulo viene vacio");
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(titulo.equals("") || titulo==null) throw new OrbisExcepcion("El titulo viene vacio");
		this.titulo = titulo;
	}
	public short getAno() {
		if(ano == 0) throw new OrbisExcepcion("El ano viene vacio");
		return ano;
	}
	public void setAno(short ano) {
		if(ano == 0) throw new OrbisExcepcion("El ano viene vacio");
		this.ano = ano;
	}
	public float getPrecio() {
		if(precio == 0) throw new OrbisExcepcion("El precio viene vacio");
		return precio;
	}
	public void setPrecio(float precio) {
		if(precio == 0) throw new OrbisExcepcion("El precio viene vacio");
		this.precio = precio;
	}
	public int getId_editorial() {
		if(id_editorial == 0) throw new OrbisExcepcion("El id_editorial viene vacio");
		return id_editorial;
	}
	public void setId_editorial(int id_editorial) {
		if(id_editorial == 0) throw new OrbisExcepcion("El id_editorial viene vacio");
		this.id_editorial = id_editorial;
	}
	
	
	
	
}
