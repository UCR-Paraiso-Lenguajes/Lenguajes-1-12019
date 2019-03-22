package cr.ac.ucr.ie.domain;

import java.util.ArrayList;
import java.util.logging.Logger;

/*Cada metodo tiene una extencion minima a las 20 linas lo cual es lo adecuado*/

public class Estudiante {
	
	ArrayList<Estudiantes> listaEstudiantes = new ArrayList<Estudiantes>();
	
	/*El nombre de los metodos tienen que ser verbos y con un nombre significativo*/
	public void AgregarEstudiante(Estudiantes estudiante) {
		listaEstudiantes.add(estudiante);
	}
	/*Los metodos no pueden tener mas de dos parametros*/
	public void EliminarEstudiante(String nombreEstudiante) {
		
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			if(nombreEstudiante.equalsIgnoreCase(listaEstudiantes.get(i).nombreEstudiante)) {
				listaEstudiantes.remove(i);
			}
		}
	}
	
	/*El nivel de abstraccion de los metodos se mantienen en el mismo nivel*/
	public String MostrarEstudiantes() {

		/*Los metodos solo realizan una accion como bien lo dice el libro*/
		String listaMostarEstudiantes = "";
		
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			listaMostarEstudiantes += listaEstudiantes.get(i).toString()+"\n";
			
		}
		return listaMostarEstudiantes;
	}
		
}
	


