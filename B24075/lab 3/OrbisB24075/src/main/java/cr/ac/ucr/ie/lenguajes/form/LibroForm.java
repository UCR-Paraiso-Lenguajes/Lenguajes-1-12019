package cr.ac.ucr.ie.lenguajes.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibroForm {
	
	private int idLibro;
	@NotNull
	@Size(min=2,max=50)
	private String titulo;
	private int ano;
	@NotNull
	private int idEditorial;
	private float precio;
	
	private int[] idAutores;
	

	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public int[] getIdAutores() {
		return idAutores;
	}
	public void setIdAutores(int[] idAutores) {
		this.idAutores = idAutores;
	}
	public LibroForm() {
	}
	
	

}