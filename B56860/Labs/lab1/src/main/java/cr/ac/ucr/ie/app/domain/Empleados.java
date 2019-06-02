package cr.ac.ucr.ie.app.domain;

import java.util.ArrayList;

public class Empleados {

	private ArrayList<Empleado> empleados = new ArrayList<>();
	
	private static int CONT_IDS=0;
	
	public Empleados(){
		Departamento financiero = new Departamento(1, "Financiero");

		agregar(new Empleado(BuscarProximoId() , "Cristian",financiero));
		agregar(new Empleado(BuscarProximoId() , "Dave" ,financiero));
		agregar(new Empleado(BuscarProximoId() , "Cristian",financiero));
		agregar(new Empleado(BuscarProximoId() , "Carlos",financiero));
		
	}

	public void agregar(Empleado empleado) {
		if(empleados.contains(empleado))  throw new RuntimeException("El empleado ya existe");
		empleados.add(empleado);
		CONT_IDS++;
	}

	public Iterable<Empleado> listar(){
		return empleados;
	}

	public int BuscarProximoId() {
		return CONT_IDS+1;
	}
	
	
	
}
