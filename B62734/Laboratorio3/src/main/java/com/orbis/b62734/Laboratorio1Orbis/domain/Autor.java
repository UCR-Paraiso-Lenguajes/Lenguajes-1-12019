package com.orbis.b62734.Laboratorio1Orbis.domain;

public class Autor {
	private int idAutor;
	private String nombreAutor;
	private String apellidosAutor;
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
	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombreAutor=" + nombreAutor + ", apellidosAutor=" + apellidosAutor
				+ "]";
	}
	
	
}
