package com.orbis.b32915.ventas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b32915.ventas.data.AutorData;
import com.orbis.b32915.ventas.domain.Autor;

@Service
public class AutorBusiness {
	
	@Autowired
	  private AutorData autorData;

	public void update(int id, Autor autor) 
	{
		/*
		if(autor == null) throw new RuntimeException("El autor es requerido.");
		if(autor.getNombreAutor().length() < 200 ) throw new RuntimeException("El nombre no puede tener más de 200 caracteres.");
		if(autor.getApellidosAutor().length() < 200 ) throw new RuntimeException("El nombre no puede tener más de 200 caracteres.");
			*/
		autorData.update(id , autor);
	}
	
	public void delete(int id) 
	{
		if(id == 0) throw new RuntimeException("El id del autor es requerido.");
			
		autorData.delete(id);
	}
	
	public Autor obtenerAutorPorId(int id) {
		
		return autorData.obtenerAutorPorId(id).next();
	}
	
}
