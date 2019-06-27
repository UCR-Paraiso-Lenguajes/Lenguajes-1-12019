package com.orbis.B63199.business;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B63199.data.LibroData;
import com.orbis.B63199.domain.Autor;
import com.orbis.B63199.domain.Libro;

@Service
public class LibroBusiness {

	@Autowired
	private LibroData libroData;

	public List<Libro> obtenerLibrosPorEditorial(int editorialId) {
		if(editorialId <=0) throw new RuntimeException("El id es inválido");
		return libroData.obtenerLibrosPorEditorial(editorialId);
	}

	public List<Autor> obtenerAutores() {
		return libroData.obtenerAutores();
	}

	public boolean guardar(Libro libro, ArrayList<Integer> idAutores) {
		try {
			if(libro == null) throw new RuntimeException("El libro es requerido.");
			libroData.guardar(libro, idAutores);
		} catch (RuntimeException e) {
			return false;
		}
		return true;
	}
}
