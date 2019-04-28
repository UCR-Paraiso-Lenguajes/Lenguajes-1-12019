package form;


import com.orbis.B78225.ventas.domain.Autor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class LibroForm {

	@NotNull
	private String titulo;
	@NotNull
	@Size(min=4,max=4)
	private int ano; 
	@NotNull
	@Size(min=13,max=13)
	private String ISBN;
	@NotNull
	private int idEditorial;
	private String[] idAutor;
	private long precio;
	private String nombreApellidos;
	private String nombre;
	private String apellidos;
	
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
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String[] getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(String[] idAutor) {
		this.idAutor = idAutor;
	}
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombre + " " + apellidos ;
	}
	
	
	
	
	
	
	
}
