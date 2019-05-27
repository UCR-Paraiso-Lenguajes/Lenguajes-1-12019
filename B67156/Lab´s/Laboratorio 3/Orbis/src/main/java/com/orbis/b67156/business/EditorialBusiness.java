package com.orbis.b67156.business;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.b67156.data.EditorialData;
import com.orbis.b67156.domain.Editorial;


public class EditorialBusiness {

	@Autowired
	private EditorialData editorialdao;
	
	public Iterator<Editorial> searchPorEditorialID(int idEditorial) {
		return editorialdao.searchPorEditorialID(idEditorial);
	}
	
	public Iterator<Editorial> searchPorEditorialRango(int inicio,int fin) {
		
		if(inicio<0  || inicio>fin) {
			throw new RuntimeException("El numero inicial del rango tiene que ser mayor a el rango final");
		}
		
		return editorialdao.searchPorEditorialRango( inicio, fin);
	}
	
}
