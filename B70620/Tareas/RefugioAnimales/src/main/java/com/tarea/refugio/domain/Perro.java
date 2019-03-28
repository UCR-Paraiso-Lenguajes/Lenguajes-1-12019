package com.tarea.refugio.domain;

public class Perro extends Animal{

	public Perro(String nombre, int edad, boolean esterilizado, boolean sociable, int peso) {
		super(nombre, edad, esterilizado, sociable, peso);
	}

	@Override
	public int cantidadComidadPorMes() {//usa funciones que operan con la informacion mas, en vez de dar los datos pg 95.
		return 5*getPeso()/getEdad();
	}

}
