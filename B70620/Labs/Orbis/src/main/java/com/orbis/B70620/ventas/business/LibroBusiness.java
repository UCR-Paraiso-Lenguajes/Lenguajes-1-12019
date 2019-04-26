package com.orbis.B70620.ventas.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B70620.ventas.data.LibroData;
import com.orbis.B70620.ventas.domain.Autor;
import com.orbis.B70620.ventas.domain.Libro;

@Service
public class LibroBusiness {
	
	@Autowired
	private LibroData libroData;
	
	public List<Libro> obtenerLibrosPorEditorial(int editorialId){
		return libroData.obtenerLibrosPorEditorial(editorialId);
	}
	
	public List<Autor> obtenerAutores(){
		return libroData.obtenerAutores();
	}

	public boolean guardar(Libro libro, ArrayList<Integer> idAutores) {
		try {
			libroData.guardar(libro, idAutores);
		}catch (RuntimeException e) {
			return false;
		}
		return true;	
	}
}
