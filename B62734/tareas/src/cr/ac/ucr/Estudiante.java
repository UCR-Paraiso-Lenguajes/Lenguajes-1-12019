package cr.ac.ucr;

public class Estudiante {
	 /*
	*Cap 2:Class Names
		**/

	private String nombre;
 /*
  *Cap 2:Use Intention-Revealing Names
  ***/
	private String cedula;
	 /*
	 *Cap 2:Use Pronounceable Names
	**/
	private String grado;
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nombre, String cedula, String grado) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.grado = grado;
	}
	/*
	 *Cap 2:Method Names
	 ***/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		grado = grado;
	}
	@Override
	public String toString() {
		return "El estudiante "+nombre+" con cedula: "+cedula+" esta en el grado"+ grado;
	}
	
	
}
