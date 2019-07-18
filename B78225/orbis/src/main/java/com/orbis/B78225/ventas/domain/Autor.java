package com.orbis.B78225.ventas.domain;

import java.util.List;

public class Autor {

	private int idAutor; 
	private String nombreAutor; 
	private String apellidosAutor;
	private String nombreApellidos;

	public Autor(int idAutor, String nombreAutor,String apellidosAutor) {
		this.idAutor = idAutor;
		this.nombreAutor =nombreAutor;
		this. apellidosAutor= apellidosAutor;
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

	public String getNombreApellidos() {
		return nombreApellidos=nombreAutor+", "+apellidosAutor;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	} 
	
	
	
	
	
}
