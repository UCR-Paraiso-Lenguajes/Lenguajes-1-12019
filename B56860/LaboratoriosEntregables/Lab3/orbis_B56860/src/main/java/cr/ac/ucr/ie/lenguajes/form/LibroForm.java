package cr.ac.ucr.ie.lenguajes.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.pl.NIP;

public class LibroForm {

	private int id_libro;
	
	@NotNull
	@Size(min =1, max =50)
	private String nombre_libro;
	@Min(1)
	private short ano;
	@Min(1)
	private float precio;
	@NotNull
	private int id_editorial;
	@NotNull
	private int id_autor;
	
	
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
	public int getId_editorial() {
		return id_editorial;
	}
	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
