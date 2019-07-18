package com.orbis.B54524.ventas.business;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B54524.ventas.data.AutorData;
import com.orbis.B54524.ventas.domain.Autor;

@Service
public class AutorBusiness {
	
	@Autowired
	private AutorData autorData;
	
	public java.util.List<Autor> obtenerAutores(String apellidos) {
		return autorData.buscarAutores(apellidos);
	}
	
	public Autor obtenerAutorPorId(int id) {
		return autorData.obtenerAutorPorId(id).get(0);
	}
	
	public void update(int id, Autor autor) {
		if(autor == null) throw new RuntimeException("La pelicula es requerida.");
		autorData.update(id , autor);
	}
	
	public void delete(int id) {
		autorData.delete(id);
	}
}
