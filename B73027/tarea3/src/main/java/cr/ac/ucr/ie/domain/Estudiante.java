package cr.ac.ucr.ie.domain;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Antisimetria de datos y objetos */
public class Estudiante implements EstudianteInterface {
	
	private ArrayList<Estudiantes> listaEstudiantes = new ArrayList<Estudiantes>();
	private final static Logger LOGGER = Logger.getLogger("");
	
	/* Para no devolver un nulos se le da un mensaje al usuario*/
	public void AgregarEstudiante(Estudiantes estudiante)throws EstudianteExcepcion {
		if(estudiante!=null) {
			listaEstudiantes.add(estudiante);
		}else {
			throw new EstudianteExcepcion("No se logro anadir el estudiante");
		}
			
	}
	
	public void EliminarEstudiante(String nombreEstudiante) throws EstudianteExcepcion{
		
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			if(nombreEstudiante.equalsIgnoreCase(listaEstudiantes.get(i).getNombreEstudiante())) {
				listaEstudiantes.remove(i);
			}else {
				throw new EstudianteExcepcion("No se logro eliminar el estudiante");
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