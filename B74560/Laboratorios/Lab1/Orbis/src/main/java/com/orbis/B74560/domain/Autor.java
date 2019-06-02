package com.orbis.B74560.domain;

public class Autor {
	
	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;
	
	public Autor(int id_autor, String nombre_autor, String apellidos_autor) {
		
		if(id_autor==0) 
			throw new RuntimeException("El id viene vació");
		if(nombre_autor.equals("") || apellidos_autor.equals("")) 
			throw new RuntimeException("Los datos viene incompletos");
		
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
		
	}
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public String getNombre_autor() {
		return nombre_autor;
	}
	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}
	public String getApellidos_autor() {
		return apellidos_autor;
	}
	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}
	
	

}
