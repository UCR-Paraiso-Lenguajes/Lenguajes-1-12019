package cr.ac.ucr.planDeEstudios.datos;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import cr.ac.ucr.planDeEstudios.dominio.Carrera;
import cr.ac.ucr.planDeEstudios.dominio.PlanEstudios;

@Repository
public class CarreraDatos {

	
	private List<Carrera> carreras = new ArrayList<Carrera>();
	

	public List<Carrera> listarCarreras() {
		
		PlanEstudios plan1 = new PlanEstudios();
		
		Carrera carrera = new Carrera( );
		carrera.setNombre("Informatica");
		carrera.setPlan(plan1);
		
		carreras.add(carrera);
		
		return carreras;
	}

}
