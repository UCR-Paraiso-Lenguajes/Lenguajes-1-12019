package cr.ac.ucr.ie.lenguajes.domain;

import java.util.List;

public class Editorial {

	private int id_editorial;
	private String nombre;
	private String direccion;
	private int telefono;
	private List<Libro> libros;
	
	public Editorial() {
		
	}
	
	public Editorial(int id_editorial, String nombre, String direccion, int telefono, List<Libro> libros) {
		super();
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.libros = libros;
	}

	private boolean validacionesString() {
		//TODO
		return true;
	}
	
	private boolean validacionesId() {
		//TODO
		return true;
	}
	
	private boolean validacionesTelefono() {
		//TODO
		return true;
	}

	public int getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
}
