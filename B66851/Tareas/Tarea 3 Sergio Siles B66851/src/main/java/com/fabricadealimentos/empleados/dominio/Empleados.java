package com.fabricadealimentos.empleados.dominio;

import java.util.ArrayList;

public class Empleados {

	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	
	
	
	public Empleados(ArrayList<Empleado> empleados) {
		Empleado primerEmpleado = new Empleado(1, "Sergio", "Siles", "Paraiso", "87654321",2300000);
		Empleado segundoEmpleado = new Empleado(2, "Fabian", "Solano", "Cartago", "67543212",100000);
		Empleado tercerEmpleado = new Empleado(3, "Juan", "Perez", "San Jose", "25117634",79999999);
		// antisimetria de datos y objetos,capitulo 6
		insertarEmpleado(primerEmpleado);
		insertarEmpleado(segundoEmpleado);
		insertarEmpleado(tercerEmpleado);
		// Ley de Demeter, Evitar los choques de trenes, conviene dividir el codigo ,capitulo 6
	}

	public void insertarEmpleado(Empleado empleadoAInsertar) {
		// no pasar null
		//try catch, capitulo 7
		try {
			empleados.add(empleadoAInsertar);
		}catch(Exception e) {
			throw new RuntimeException("Error al ingresar el empleado");
		}
		
	}
	
	// Abtraccion de los datos, capitulo 6
	public float salarioPromedio() {
		float salarioPromedio = 0;
		
		for(int iterador = 0; iterador < empleados.size(); iterador++)
		{
			Empleado empleadoTemporal = empleados.get(iterador);
			float salarioDeEmpleado = empleadoTemporal.getSalario();
			salarioPromedio = salarioPromedio+salarioDeEmpleado;
		}
		return salarioPromedio/empleados.size();
		// no devolver null, capitulo 7
		
		
	}
	
	
	
	
	public Iterable<Empleado> listar()
	{
		return empleados;
	}
}
