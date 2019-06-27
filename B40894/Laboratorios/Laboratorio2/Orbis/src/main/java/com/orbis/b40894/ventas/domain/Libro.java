package com.orbis.b40894.ventas.domain;

public class Libro {

	private int id_libro;
	private String titulo;
	private int ano;
	private double precio;
	private int idEditorial;

	public Libro() {

	}

	public Libro(int id_libro, String titulo, int ano, double precio, int idEditorial) {

		this.id_libro = id_libro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.idEditorial = idEditorial;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", titulo=" + titulo + ", ano=" + ano + ", precio=" + precio
				+ ", idEditorial=" + idEditorial + "]";
	}

}
