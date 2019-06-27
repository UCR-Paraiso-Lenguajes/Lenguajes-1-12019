package com.orbis.b63817.ventas.logica;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.ventas.datos.AutorDatos;
import com.orbis.b63817.ventas.dominio.Autor;


@Service
public class AutorLogica {
	
	@Autowired
	private AutorDatos AutorDatos;
	
	public Iterator<Autor> mostrarAutores(){
		return AutorDatos.mostrarAutores();
	}

}
