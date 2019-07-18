package com.orbis.B77436.domain;

import java.util.List;

public class Libro_Autor {
	
	private int id_libro;
	private List<Integer> id_autor;
	public Libro_Autor(int id_libro, List<Integer> id_autor) {
		if(id_autor.size()==0  ) throw new RuntimeException("Los id_autor vienen vacios");
		if(id_libro==0) throw new RuntimeException("Los id_libro vienen vacios");
		this.id_libro = id_libro;
		this.id_autor = id_autor;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public List<Integer> getId_autor() {
		return id_autor;
	}
	public void setId_autor(List<Integer> id_autor) {
		this.id_autor = id_autor;
	}
	
	

}
