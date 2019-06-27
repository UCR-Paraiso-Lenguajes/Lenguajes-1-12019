package com.orbis.B76223.ventas.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B76223.ventas.data.LibroData;
import com.orbis.B76223.ventas.domain.Libro;

@Service
public class LibroBusiness {

	@Autowired
	LibroData libroData; 
	
public Libro saveLibroAutor(Libro libro) throws SQLException {
		
		if(libro == null) throw new RuntimeException("El libro es requerida");
		if(libro.getTitulo().length() > 200)throw new RuntimeException("el nombre no puede tener mas de 200 caracteres");
		if(libro.getEditorial().getIdEditorial() < 0)	throw new RuntimeException("el editorial es requerido");
		if(libro.getAno() > 2019) throw new RuntimeException("El año debe ser válido");
		if(libro.getAutores().size()==0) throw new RuntimeException("La lista de autores debe tener al menos un autor");
		
		return libroData.save(libro);
	}
}
