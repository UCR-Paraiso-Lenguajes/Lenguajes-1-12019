package com.orbis.b63817.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.datos.LibroDatos;
import com.orbis.b63817.dominio.Libro;

@Service
public class LibroLogica {
	
	@Autowired
	private LibroDatos libroDatos;
	
	
	public List<Libro> buscarLibro(int id_Editorial) {
		return libroDatos.mostrarLibros(id_Editorial);
	}

}
