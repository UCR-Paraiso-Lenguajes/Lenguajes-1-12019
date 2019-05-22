package cr.ac.ucr.ie.lenguajes.domain;

public class Autor {
	
	private String nombre, apellidos;
	private int idAutor;
	
	public Autor(String nombre, String apellidos, int idAutor) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idAutor = idAutor;
	}
	
	
	public Autor() {
		this.nombre = "";
		this.apellidos = "";
		this.idAutor = 0;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	
	

}
