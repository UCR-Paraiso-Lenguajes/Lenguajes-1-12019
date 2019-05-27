package com.orbis.b63817.ventas.dominio;

import java.util.ArrayList;

public class Autor {
	
	private int id_autor;
	private String nombre_Autor;
	private String apellidos_autor;
	private String telefono;
	private ArrayList<Libro> listaLibros;
	
	public Autor() {
		
	}

	public Autor(int id_autor, String nombre_autor, String apellidos_autor, String telefono, ArrayList<Libro> listaLibros) {
		super();
		if(id_autor <0) throw new RuntimeException("El id de Autor debe ser mayor  0.");
		if(nombre_autor == null || nombre_autor.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(apellidos_autor == null || apellidos_autor.trim().equals("")) throw new RuntimeException("El apellido es requerido");
		if(telefono == null || telefono.trim().equals("")) throw new RuntimeException("El telefono es requerido");
		this.id_autor = id_autor;
		this.nombre_Autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
		this.telefono= telefono;
		this.listaLibros = listaLibros;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre_Autor() {
		return nombre_Autor;
	}

	public void setNombre_Autor(String nombre_Autor) {
		this.nombre_Autor = nombre_Autor;
	}

	public String getApellidos_autor() {
		return apellidos_autor;
	}

	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}

	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", nombre_Autor=" + nombre_Autor + ", apellidos_autor=" + apellidos_autor
				+ ", telefono=" + telefono + ", listaLibros=" + listaLibros + "]";
	}
	

}
