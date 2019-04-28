package com.orbis.B76223.ventas.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B76223.ventas.data.EditorialData;
import com.orbis.B76223.ventas.data.LibroData;
import com.orbis.B76223.ventas.domain.Editorial;
import com.orbis.B76223.ventas.domain.Libro;

@Service
public class EditorialBusiness {

	@Autowired
	private EditorialData editorialData;
	@Autowired
	private LibroData libroData;
	
	public List<Editorial> listarEditorial(int numInicio, int numFinal){	
		return editorialData.listarEditorial(numInicio, numFinal);
	}
	
	public List<Libro> listarLibrosPorEditorial(int idEditorial) {
		return editorialData.listarLibrosPorEditorial(idEditorial);	
	}
		
}
