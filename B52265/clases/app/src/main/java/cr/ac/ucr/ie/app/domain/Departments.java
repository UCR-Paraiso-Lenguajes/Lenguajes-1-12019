package cr.ac.ucr.ie.app.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Departments {
	private ArrayList<Department> departamentos = new ArrayList<Department>();

	public Departments() {
		departamentos.add(new Department(1, "Recursos Humanos"));
		departamentos.add(new Department(2, "Registro"));
		departamentos.add(new Department(3, "Finanzas"));
	}

	public Iterator<Department> Listar() {
		return departamentos.iterator();
	}

	public Department BuscarXId(int departamento) {
		for (Department depto : departamentos) {
			if (depto.getCod() == departamento)
				return depto;

		}
		throw new RuntimeException("El departamento " + departamento + " no existe.");
	}
}
