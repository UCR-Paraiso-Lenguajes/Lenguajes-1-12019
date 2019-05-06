package com.orbis.B77436.domain;

public class Libro_Autor {
	
	private int id_libro;
	private int id_autor;
	public Libro_Autor(int id_libro, int id_autor) {
		if(id_autor ==0 || id_libro==0) throw new RuntimeException("Los id vienen vacios");
		this.id_libro = id_libro;
		this.id_autor = id_autor;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	
	

}
