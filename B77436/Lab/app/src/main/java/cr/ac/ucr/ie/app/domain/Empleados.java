package cr.ac.ucr.ie.app.domain;

import java.util.ArrayList;

public class Empleados {

	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private static int CONT_IDS=0;
	public Empleados ()
	{
		Departamento finanziero = new Departamento(1, "Financiero");
		
		Agregar(new Empleado(BuscarProximoId() , "Cristian",finanziero));
		Agregar(new Empleado(BuscarProximoId() , "Dave" ,finanziero));
		Agregar(new Empleado(BuscarProximoId() , "Cristian",finanziero));
		Agregar(new Empleado(BuscarProximoId() , "Carlos",finanziero));
	}

	public void Agregar(Empleado empleado)
	{
		if (empleados.contains(empleado) )throw new RuntimeException("El empleado ya existe");
		empleados.add(empleado);
		CONT_IDS++;
	}

	public Iterable<Empleado> listar()
	{
		return empleados;
	}

	public int BuscarProximoId() {

		return CONT_IDS+1;
	}
	
	
	
}
