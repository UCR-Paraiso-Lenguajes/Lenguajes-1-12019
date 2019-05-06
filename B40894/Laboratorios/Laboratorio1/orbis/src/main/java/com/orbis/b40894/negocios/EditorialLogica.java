package com.orbis.b40894.negocios;
import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.b40894.datos.EditorialDatos;
import com.orbis.b40894.dominio.Editorial;

@Service
public class EditorialLogica {
@Autowired
	private EditorialDatos editorialDao;
	
	public Iterator<Editorial> buscarEditorial(int cantidadInicio,int cantidadFin) {
		return editorialDao.buscarEditorial(cantidadInicio,cantidadFin);
	}
}



