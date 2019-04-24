package com.orbis.b54524.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b54524.datos.EditorialDatos;
import com.orbis.b54524.dominio.Editorial;

@Service
public class EditorialBusiness {
	
	@Autowired
	private EditorialDatos editorialDatos;
	
	public Iterator<Editorial> listarEditoriales (int inicioRegistros, int finRegistros) {
		return editorialDatos.listarEditoriales(inicioRegistros, finRegistros);
	}
}
