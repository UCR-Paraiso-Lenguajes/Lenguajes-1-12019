package com.orbis.b63817.ventas.logica;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.ventas.datos.EditorialDatos;
import com.orbis.b63817.ventas.dominio.Editorial;

@Service
public class EditorialLogica {
	
	@Autowired
	private EditorialDatos EditorialDao;
	
	public Iterator<Editorial> listarEditoriales(int cantidadInicial, int cantidadFinal) {
		return EditorialDao.listadoEditoriales(cantidadInicial, cantidadFinal);
	}

	

}
