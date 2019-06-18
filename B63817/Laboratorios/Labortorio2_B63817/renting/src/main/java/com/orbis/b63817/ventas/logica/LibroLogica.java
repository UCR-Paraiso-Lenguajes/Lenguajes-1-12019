package com.orbis.b63817.ventas.logica;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.ventas.datos.LibroDatos;
import com.orbis.b63817.ventas.dominio.Libro;


@Service
public class LibroLogica {
	
	@Autowired
	private LibroDatos libroDatos;
	
	public Iterator<Libro> mostrarLibros(int id_Editorial){
		return libroDatos.mostrarLibros(id_Editorial);
	}

}
