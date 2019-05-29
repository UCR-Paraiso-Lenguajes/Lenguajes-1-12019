package com.orbis.B76223.ventas.domain;

import java.util.List;

public class Autor {

	private int idAutor; 
	private String nombreAutor; 
	private String apellidosAutor;
	private String nombreApellidos;
	
	public Autor() {
		// TODO Auto-generated constructor stub
	}

	public Autor(int idAutor, String nombreAutor, String apellidosAutor) {
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor; 
		this.apellidosAutor = apellidosAutor;
	}
	
	public Autor(int idAutor) {
		this.idAutor = idAutor;
	}
	
	public String getNombreApellidos() {
		return  this.apellidosAutor + ", " + this.nombreAutor;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidosAutor() {
		return apellidosAutor;
	}
	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	} 
	
}
