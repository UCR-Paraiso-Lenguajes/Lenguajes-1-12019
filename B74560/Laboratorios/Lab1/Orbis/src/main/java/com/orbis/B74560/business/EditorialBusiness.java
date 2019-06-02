package com.orbis.B74560.business;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;

import com.orbis.B74560.data.EditorialData;
import com.orbis.B74560.domain.Editorial;


public class EditorialBusiness {

	@Autowired
	private EditorialData editorialDao;
	
	public Iterator<Editorial> buscarPorEditorial(int id_editorial) {
		return editorialDao.buscarPorEditorial(id_editorial);
	}
	
	public Iterator<Editorial> buscarEditorialRango(int rangoInicio,int rangoFinal) {
		return editorialDao.buscarEditorialRango( rangoInicio, rangoFinal);
	}
	
}
