package com.orbis.b67156.domain;

import java.util.List;

public class Libro_Autor {

	private int id_libro;
	private List<Integer> listAutores;
	
	public Libro_Autor(int id_libro, List<Integer> list) {
		if( id_libro==0) throw new RuntimeException("el  id viene vacio");
		this.id_libro = id_libro;
		this.listAutores = list;
	}
	
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public List<Integer> getListAutores() {
		return listAutores;
	}

	public void setListAutores(List<Integer> listAutores) {
		this.listAutores = listAutores;
	}
}
