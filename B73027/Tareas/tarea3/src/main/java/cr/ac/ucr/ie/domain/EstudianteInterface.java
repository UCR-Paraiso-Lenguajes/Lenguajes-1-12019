package cr.ac.ucr.ie.domain;

/*Abtraccion de datos*/
/* se define un flujo de da datos normal debido a que se separa la parte empresarial de la logica */
public interface EstudianteInterface {
	
	public void AgregarEstudiante(Estudiantes estudiante);
	public void EliminarEstudiante(String nombreEstudiante);
	public String MostrarEstudiantes();

}
