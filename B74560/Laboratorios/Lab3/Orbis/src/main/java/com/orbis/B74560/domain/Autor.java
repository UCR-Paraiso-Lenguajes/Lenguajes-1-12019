package com.orbis.B74560.domain;

import com.orbis.B74560.exception.ExceptionsOrbis;

public class Autor {

	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;

	public Autor(int id_autor, String nombre_autor, String apellidos_autor) {

		if (id_autor <= 0)
			throw new ExceptionsOrbis("El id está vació");
		if (nombre_autor.trim().equals("") || apellidos_autor.trim().equals(""))
			throw new ExceptionsOrbis("Los datos están incompletos");
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;

	}

	public Autor() {
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		if (id_autor <= 0)
			throw new ExceptionsOrbis("El id está vació");
		this.id_autor = id_autor;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		if (nombre_autor.trim().equals(""))
			throw new ExceptionsOrbis("Los datos del nombre están vacios");
		this.nombre_autor = nombre_autor;
	}

	public String getApellidos_autor() {
		return apellidos_autor;
	}

	public void setApellidos_autor(String apellidos_autor) {
		if (apellidos_autor.trim().equals(""))
			throw new ExceptionsOrbis("Los datos del apellido están vacios");
		this.apellidos_autor = apellidos_autor;
	}

}
