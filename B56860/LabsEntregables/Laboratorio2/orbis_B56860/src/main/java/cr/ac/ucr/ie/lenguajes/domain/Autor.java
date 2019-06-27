package cr.ac.ucr.ie.lenguajes.domain;

import java.util.List;

public class Autor {
	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;
	private List<Libro> libros;
	
	
	public Autor() {
	}

	public Autor(int id_autor, String nombre_autor, String apellidos_autor, List<Libro> libros) {
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
		this.libros = libros;
	}

	private boolean validacionesId() {
		//TODO
		return true;
	}
	
	private boolean validacionesString() {
		//TODO
		return true;
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
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
}
