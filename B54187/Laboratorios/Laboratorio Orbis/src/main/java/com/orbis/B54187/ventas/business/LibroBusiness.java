package com.orbis.B54187.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.B54187.ventas.data.LibroData;
import com.orbis.B54187.ventas.domain.*;;

public class LibroBusiness {
	
	@Autowired
	private LibroData libroData;

	public List<Libro> mostrarLibro(int idEditorial) {
		return libroData.mostrarLibro(idEditorial);
	}
}
