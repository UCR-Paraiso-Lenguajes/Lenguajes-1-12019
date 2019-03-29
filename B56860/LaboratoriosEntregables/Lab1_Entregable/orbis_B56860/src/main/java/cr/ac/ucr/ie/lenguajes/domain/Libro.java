package cr.ac.ucr.ie.lenguajes.domain;

public class Libro {
	private int id_libro;
	private String nombre_libro;
	private short ano;
	private float precio;
	
	
	public Libro() {
		
	}
	
	public Libro(int id_libro, String nombre_libro, short ano, float precio) {
		setId_libro(id_libro);
		setNombre_libro(nombre_libro);
		setAno(ano);
		setPrecio(precio);
	}

	private boolean validacionesString() {
		//TODO
		return true;
	}
	
	private boolean validacionesId() {
		//TODO
		return true;
	}
	
	private boolean validacionesFecha() {
		//TODO
		return true;
	}
	
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public String getNombre_libro() {
		return nombre_libro;
	}
	public void setNombre_libro(String nombre_libro) {
		this.nombre_libro = nombre_libro;
	}
	public short getAno() {
		return ano;
	}
	public void setAno(short ano) {
		this.ano = ano;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
