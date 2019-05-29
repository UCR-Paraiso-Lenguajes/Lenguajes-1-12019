package com.orbis.b63685.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63685.data.AutorData;
import com.orbis.b63685.data.LibroData;
import com.orbis.b63685.domain.Autor;
import com.orbis.b63685.domain.Libro;

@Service
public class LibroBusiness {

@Autowired
private LibroData libroData;

	public LibroBusiness() {

		
	}
	
	public List<Libro> buscarPorEditorial(int codEditorial) {
		
		return libroData.buscarPorEditorial(codEditorial);
		
		
	}
	
	
	

}
