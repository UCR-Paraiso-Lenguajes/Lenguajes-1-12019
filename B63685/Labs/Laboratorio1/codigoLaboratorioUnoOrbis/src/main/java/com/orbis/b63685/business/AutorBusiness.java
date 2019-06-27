package com.orbis.b63685.business;

import java.util.ArrayList;
import java.util.List;

import com.orbis.b63685.data.AutorData;
import com.orbis.b63685.domain.Autor;

public class AutorBusiness {
	
	private ArrayList<Autor> autores;
	
	public AutorBusiness() {
		
		autores = new ArrayList<Autor>();
		
	}
	
	public List<Autor> listarAutores(int inicio, int end) {

		
		AutorData autorData = new AutorData();
		
		autores =  (ArrayList<Autor>) autorData.listarAutores(inicio, end);

		if (autores == null) throw new RuntimeException("autores no puede ser nulo.");
		
		else {
			return autores;
		}

		
	}

}
