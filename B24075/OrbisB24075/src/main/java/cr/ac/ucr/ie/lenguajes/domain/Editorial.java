package cr.ac.ucr.ie.lenguajes.domain;

public class Editorial {
	
	public int idEditorial;
	public String nombre, direccion, telefono;
	
	
	
	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editorial(int idEditorial, String nombre, String direccion, String telefono) {
		super();
		this.idEditorial = idEditorial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
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
	public String getTeledono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	

}
