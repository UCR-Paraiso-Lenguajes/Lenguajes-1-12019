package com.tarea.refugio.domain;

public class Gato extends Animal{

	public Gato(String nombre, int edad, boolean esterilizado, boolean sociable, int peso) {
		super(nombre, edad, esterilizado, sociable, peso);
	}

	@Override
	int cantidadComidadPorMes() {
		return 2*getPeso()/getEdad();
	}

}
