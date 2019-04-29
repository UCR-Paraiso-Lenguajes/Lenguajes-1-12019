package com.orbis.B74560.domain;

import java.util.Calendar;

public class Libro {

	private int id_libro;
	private String titulo;
	private short ano;
	private float precio;
	private int id_editorial;
	private final Calendar calendar = Calendar.getInstance();
	private final int anoActual = calendar.get(Calendar.YEAR);

	public Libro(int id_libro, String titulo, short ano, float precio, int id_editorial) {

		if (id_libro <= 0 || id_editorial <= 0 || ano <= 0 || precio <= 0)
			throw new RuntimeException("Hay datos imcompletos");
		if (ano > anoActual)
			throw new RuntimeException("Hay datos erroneos");
		if (titulo.trim().equals(""))
			throw new RuntimeException("Hay datos vacíos");

		this.id_libro = id_libro;
		this.titulo = titulo;
		this.ano = ano;
		this.precio = precio;
		this.id_editorial = id_editorial;

	}

	public Libro() {
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		if (id_libro <= 0)
			throw new RuntimeException("Hay datos imcompletos");
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo.trim().equals(""))
			throw new RuntimeException("Hay datos vacíos");
		this.titulo = titulo;
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		if ((ano > anoActual) && (ano <= 0))
			throw new RuntimeException("El año está erroneo");
		this.ano = ano;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		if (precio <= 0)
			throw new RuntimeException("Hay datos imcompletos");
		this.precio = precio;
	}

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		if (id_editorial <= 0)
			throw new RuntimeException("Hay datos imcompletos");
		this.id_editorial = id_editorial;
	}

}
