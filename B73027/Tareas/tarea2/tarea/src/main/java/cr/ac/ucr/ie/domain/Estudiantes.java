package cr.ac.ucr.ie.domain;

import java.util.logging.Logger;

/* Segun el libro los nombres de las clases tienen que ser un sustantivo y no un verbo */
public class Estudiantes {
/*El nombre de las variables tiene que ser representativo al metodo*/
	String nombreEstudiante;
	String apellidoEstudiante;
	int carnetEstudiante;
	
	public Estudiantes(String nombreEstudiante, String apellidoEstudiante,int carnetEstudiante) {
		
		if(nombreEstudiante == null && nombreEstudiante.trim().equals("")) throw new RuntimeException("el nombre del estudiante es requerido");
		if(apellidoEstudiante == null && apellidoEstudiante.trim().equals("")) throw new RuntimeException("el apellido del estudiante es requerido");
		if(carnetEstudiante <= 0) throw new RuntimeException("el id debe ser mayor a 0");
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.carnetEstudiante = carnetEstudiante;
	}
	
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}
	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}
	public int getCarnetEstudiante() {
		return carnetEstudiante;
	}
	public void setCarnetEstudiante(int carnetEstudiante) {
		this.carnetEstudiante = carnetEstudiante;
	}

	@Override
	public String toString() {
		return "nombre " + nombreEstudiante + ", apellido " + apellidoEstudiante
				+ ", carnet " + carnetEstudiante ;
	}
	
	
		
}