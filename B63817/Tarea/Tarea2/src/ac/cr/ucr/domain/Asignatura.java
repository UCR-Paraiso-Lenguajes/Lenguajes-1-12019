package ac.cr.ucr.domain;


public class Asignatura {

	private String nombre;
	private double calificacion;
	public Asignatura(String nombre, double calificacion) {
		super();
		this.nombre = nombre;
		this.calificacion = calificacion;
	}
//Tip Cap3 No repetirse	
//Tip Cap2 Nombres de mètodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", calificacion=" + calificacion + "]";
	}

	
	
	
	
}
