package cr.ac.ucr.ie.TareasLen3.domain;

public abstract class Medico {
	private String nombre=" ";
	private String cedula=" ";
	private String numeroTelefono=" ";
	private boolean disponibilidad=false;
	
	
	public Medico(String nombre, String cedula, String numeroTelefono, boolean disponibilidad) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.numeroTelefono = numeroTelefono;
		this.disponibilidad = disponibilidad;
	}
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
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	

}
