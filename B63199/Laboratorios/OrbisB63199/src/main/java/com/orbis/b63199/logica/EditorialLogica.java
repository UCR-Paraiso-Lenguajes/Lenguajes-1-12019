package com.orbis.b63199.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63199.datos.EditorialDatos;
import com.orbis.b63199.dominio.Editorial;

@Service
public class EditorialLogica {
	
	@Autowired
	private EditorialDatos editorialDatos;
	
	public List<Editorial> buscarEditorial(int primera, int ultima) {
		return editorialDatos.listarEditoriales(1, 100);
	}
	
}
