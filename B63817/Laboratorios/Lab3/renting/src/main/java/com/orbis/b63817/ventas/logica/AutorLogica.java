package com.orbis.b63817.ventas.logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.ventas.datos.AutorDatos;
import com.orbis.b63817.ventas.dominio.Autor;

@Service
public class AutorLogica {

	@Autowired
	private AutorDatos autorDatos;

	public Iterator<Autor> mostrarAutores() {
		return autorDatos.mostrarAutores();
	}

	public Autor consultaAutorPorID(int id_autor) {
		return autorDatos.mostrarAutorPorId(id_autor).get(0);
	}

	public void update(int id, Autor autor) {
		if (autor == null)
			throw new RuntimeException("El autor es requerida.");
		if (autor.getNombre_Autor().length() > 200)
			throw new RuntimeException("El nombre no puede tener más de 200 caracteres.");
		if (autor.getApellidos_autor() == null)
			throw new RuntimeException("El apellido es requerido");
 System.out.println(autor.toString());
		autorDatos.update(id, autor);
	}

	public void delete(int id) {
		autorDatos.delete(id);
		System.out.println(id);
		
	}

	

	
}