package ejemplos;

/**
 * Clase utilizada para subtema "Ruinas del tren" del capitulo 6
 * La clase se utilizará como una estructura de datos para no violar la 
 * Ley de Demeter
 * @author Jean Carlos Monge Mendez 
 * 
 */

public class Edificio {
	public String nombre;
	public Ubicacion ubicacion;
	
}

/**
 * Clase utilizada para subtema "Objetos de transferencia de datos" del capitulo 6
 * Ejemplo de clase "Bean" o clase "Frijol"
 * @author Jean Carlos Monge Mendez
 *
 */
class Ubicacion{
	
	public String nombre;
	public double latitud;
	public double altitud;
	public String getNombre() {
		return nombre;
	}
	
	public Ubicacion(String nombre, double latitud, double altitud) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.altitud = altitud;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getAltitud() {
		return altitud;
	}
	public void setAltitud(double altitud) {
		this.altitud = altitud;
	}
	
}
