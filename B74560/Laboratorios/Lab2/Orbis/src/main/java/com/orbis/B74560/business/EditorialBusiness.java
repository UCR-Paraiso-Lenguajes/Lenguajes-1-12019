package com.orbis.B74560.business;

import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B74560.data.EditorialData;
import com.orbis.B74560.domain.Editorial;

@Service
public class EditorialBusiness {

	@Autowired
	private EditorialData editorialDao;

	public Iterator<Editorial> buscarEditorial(int idEditorial) {
		return editorialDao.buscarEditorial(idEditorial);
	}// fin del Iterator<Editorial> buscarPorId

	public Iterator<Editorial> buscarEditorialRango(int rangoInicio, int rangoFinal) {

		if (rangoInicio < rangoFinal) {
			return editorialDao.buscarEditorialRango(rangoInicio, rangoFinal);
		} else {
			return editorialDao.buscarEditorialRango(rangoFinal, rangoInicio);
		} // fin del if

	}// fin del Iterator<Editorial> buscarPorRango

}// fin de EditorialBusiness
