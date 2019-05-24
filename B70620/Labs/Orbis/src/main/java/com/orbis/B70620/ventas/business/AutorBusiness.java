package com.orbis.B70620.ventas.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B70620.ventas.data.AutorData;
import com.orbis.B70620.ventas.domain.Autor;

@Service
public class AutorBusiness {

	@Autowired
	private AutorData autorData;
	

	public List<Autor> obtenerAutoresPorApellidos(String apellidos) {
		if(apellidos == null || apellidos.equals("")) return new ArrayList<>();
		return autorData.obtenerAutoresPorApellidos(apellidos);
	}


	public void editarAutor(Autor autor) {
		autorData.editarAutor(autor); 
	}


	public void eliminarAutor(Autor autor) {
		autorData.eliminarAutor(autor); 
		
	}

}
