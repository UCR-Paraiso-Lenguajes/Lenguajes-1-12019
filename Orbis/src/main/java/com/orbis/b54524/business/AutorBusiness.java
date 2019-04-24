package com.orbis.b54524.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.b54524.datos.AutorDatos;
import com.orbis.b54524.dominio.Autor;


@Service
public class AutorBusiness {
	
	@Autowired
	private AutorDatos autorData;

	public Iterator<Autor> encontrarAutores() {
		return autorData.encontrarAutores();
	}
}

