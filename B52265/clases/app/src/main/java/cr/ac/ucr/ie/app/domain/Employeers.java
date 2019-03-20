package cr.ac.ucr.ie.app.domain;

import java.util.ArrayList;
import java.util.List;
import cr.ac.ucr.ie.app.domain.*;

public class Employeers {
	private ArrayList<Employeer> empleados = new ArrayList<Employeer>();
	private static int CONT_IDS = 0;

	public Employeers() {
		Department finanziero = new Department(1, "Financiero");

		Agregar(new Employeer(1, "Cristian", finanziero));
		Agregar(new Employeer(2, "Dave", finanziero));
		Agregar(new Employeer(3, "Cristian", finanziero));
		Agregar(new Employeer(4, "Carlos", finanziero));
	}

	public void Agregar(Employeer empleado) {
		if (empleados.contains(empleado))
			throw new RuntimeException("El empleado ya existe");
		empleados.add(empleado);
		CONT_IDS++;
	}

	public Iterable<Employeer> listar() {
		return empleados;
	}

	public int BuscarProximoId() {

		return CONT_IDS + 1;
	}
}
