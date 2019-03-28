package com.tarea.refugio.bussines;

import java.util.List;

import com.tarea.refugio.data.AnimalData;
import com.tarea.refugio.domain.Animal;

public class AnimalBusiness {
	AnimalData animalData = new AnimalData();
	
	public List<Animal> listarAnimales(){
		return animalData.obtenerAnimales();
	}
}