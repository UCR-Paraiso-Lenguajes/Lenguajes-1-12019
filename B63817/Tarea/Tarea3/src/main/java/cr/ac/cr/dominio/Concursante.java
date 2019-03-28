package cr.ac.cr.dominio;

public class Concursante {

	private String nombre;
	
	
	public Concursante() {
		
	}

	public Concursante(String nombre) {
		//Cap7-caso8: No pasar Null
	if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		this.nombre = nombre;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return "Concursante [nombre=" + nombre + "]";
	}
	
	
}
