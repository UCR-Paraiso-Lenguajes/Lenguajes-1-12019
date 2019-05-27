package com.orbis.B63199.business;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B63199.data.AutorData;
import com.orbis.B63199.domain.Autor;

@Service
public class AutorBusiness {
	
	@Autowired
	private AutorData autorData;
	
	public java.util.List<Autor> obtenerAutores(String apellidos) {
		//if(apellidos.length() < 2 ) throw new RuntimeException("El apellido no es válido"); 
		return autorData.buscarAutores(apellidos);
	}
	
	public Autor obtenerAutorPorId(int id) {
		if(id <=0) throw new RuntimeException("El id del autor no es válido");
		return autorData.obtenerAutorPorId(id).get(0);
	}
	
	public void update(int id, Autor autor) {
		
		if(autor == null) throw new RuntimeException("El autor es requerido.");
		if(id <=0 ) throw new RuntimeException("El id no es válido");
		autorData.modificarAutorPorId(id, autor);
	}
	
	public void delete(int id) {
		
		if(id <=0 ) throw new RuntimeException("El id no es válido");
		autorData.eliminarAutorConId(id);
	}
}
