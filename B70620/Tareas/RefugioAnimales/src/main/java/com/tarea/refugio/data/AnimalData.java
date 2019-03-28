package com.tarea.refugio.data;

import java.util.List;
import java.util.ArrayList;
import com.tarea.refugio.domain.Animal;
import com.tarea.refugio.domain.Gato;
import com.tarea.refugio.domain.Perro;

public class AnimalData {
	
	List<Animal> listaAnimales = new ArrayList<>();//Inicializada para que no retorne nulos pg110.
	
	public List<Animal> obtenerAnimales() {
		llenarListaAnimales();
		return listaAnimales;
	}

	private void llenarListaAnimales() {
		listaAnimales.add(new Perro("Rufus", 5,true,false, 12));
		listaAnimales.add(new Gato("Misifus", 8,false,false, 7));
		listaAnimales.add(new Perro("Canelo", 2,true,true, 24));
		listaAnimales.add(new Gato("Atena", 11,false,false, 4));
		listaAnimales.add(new Perro("Fifi", 15,true,false, 9));
		listaAnimales.add(new Gato("Misifus", 8,false,true, 7));
	}
}
