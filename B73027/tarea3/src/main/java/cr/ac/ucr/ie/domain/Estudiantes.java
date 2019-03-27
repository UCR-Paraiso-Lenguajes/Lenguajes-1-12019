package cr.ac.ucr.ie.domain;

public class Estudiantes {
/*El nombre de las variables tiene que ser privadas segun la ley de Demeter*/
	private String nombreEstudiante;
	private String apellidoEstudiante;
	private int carnetEstudiante;
	
	/*Objetos de transferencia de datos se basa en la utilizacion de get,set y los constructores*/
	public Estudiantes(String nombreEstudiante, String apellidoEstudiante,int carnetEstudiante) throws EstudianteExcepcion {
		
		/* Usar excepciones en lugar de codigos devuelto*/
		if(nombreEstudiante == null && nombreEstudiante.trim().equals("")) throw new EstudianteExcepcion("el nombre del estudiante es requerido");
		/*No permite que se pasen nullos al metodo*/
		if(apellidoEstudiante == null && apellidoEstudiante.trim().equals("")) throw new EstudianteExcepcion("el apellido del estudiante es requerido");
		/*Ofrecder un contexto junto a las excepciones */
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