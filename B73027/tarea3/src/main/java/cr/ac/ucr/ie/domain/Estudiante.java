package cr.ac.ucr.ie.domain;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Antisimetria de datos y objetos */
public class Estudiante implements EstudianteInterface {
	
	private ArrayList<Estudiantes> listaEstudiantes = new ArrayList<Estudiantes>();
	private final static Logger LOGGER = Logger.getLogger("");
	
	/* Para no devolver un nulos se le da un mensaje al usuario*/
	public void AgregarEstudiante(Estudiantes estudiante) {
		if(estudiante!=null) {
			listaEstudiantes.add(estudiante);
		}else {
			LOGGER.log(Level.WARNING,"No se logro añadir estudiante");
		}
			
	}
	
	public void EliminarEstudiante(String nombreEstudiante) {
		
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			if(nombreEstudiante.equalsIgnoreCase(listaEstudiantes.get(i).getNombreEstudiante())) {
				listaEstudiantes.remove(i);
			}else {
				LOGGER.log(Level.WARNING,"No se encontro el estudiante a eliminar");
			}
		}
	}
	
	public String MostrarEstudiantes() {

		String listaMostarEstudiantes = "";
		
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			listaMostarEstudiantes += listaEstudiantes.get(i).toString()+"\n";
			
		}
		return listaMostarEstudiantes;
	}
	
	
		
}