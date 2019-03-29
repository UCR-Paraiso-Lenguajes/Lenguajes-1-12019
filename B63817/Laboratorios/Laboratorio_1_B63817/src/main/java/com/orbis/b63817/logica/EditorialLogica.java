package com.orbis.b63817.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63817.datos.EditorialDatos;
import com.orbis.b63817.dominio.Editorial;

@Service
public class EditorialLogica {
	@Autowired
	private EditorialDatos editorialDatos;
	
	
	public List<Editorial> listarEditoriales(int cantidadInicial, int cantidadFinal) {
		if(cantidadFinal <0) throw new RuntimeException("Cantidad Final debe ser mayor a  0.");
		if(cantidadInicial <0) throw new RuntimeException("Cantidad Inicial debe ser mayor a 0.");
		
		return editorialDatos.listadoEditoriales(cantidadInicial, cantidadFinal);
	}
}
