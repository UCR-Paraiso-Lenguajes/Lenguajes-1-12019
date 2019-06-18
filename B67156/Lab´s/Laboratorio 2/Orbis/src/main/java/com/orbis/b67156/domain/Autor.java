package com.orbis.b67156.domain;

public class Autor {
	
	private int id_Autor;
	private String nombre_Autor;
	private String apellidos_Autor;
	
	public Autor(int id_autor, String nombre_autor, String apellidos_autor) {
		if(id_autor==0) throw new RuntimeException("El id viene vació");
		if(nombre_autor.equals("") || apellidos_autor.equals("")) throw new RuntimeException("Los datos viene incompletos");
		this.id_Autor = id_autor;
		this.nombre_Autor = nombre_autor;
		this.apellidos_Autor = apellidos_autor;
	}

	public int getIdAutor() {
		return id_Autor;
	}

	public void setIdAutor(int idAutor) {
		this.id_Autor = idAutor;
	}

	public String getNombreAutor() {
		return nombre_Autor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombre_Autor = nombreAutor;
	}

	public String getApellidosAutor() {
		return apellidos_Autor;
	}

	public void setApellidosAutor(String apellidosAutor) {
		this.apellidos_Autor = apellidosAutor;
	}
	
	

}
