package cr.ac.ucr.ie.tarea3.domain;


//Tip 1:
//Abstración de datos. Basado en pagina 93. donde se implementa la abstracion de los metodos
public interface Curso {
	
	public String obtenerNombreCurso(String nombreCurso) throws Exception;
	public String obtenerNombreProfesor(String nombreProfesor) throws Exception;
	public void obtenerHorasEstudioEstudiante(int cantidadCreditos, 
			int horasSemanales) throws Exception;
	
}
