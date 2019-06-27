package com.orbis.B74560.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B74560.data.AutorData;
import com.orbis.B74560.domain.Autor;

@Service
public class AutorBusiness {

	@Autowired // Inicializa
	private AutorData autorDao;

	public List<Autor> buscarAutor(int rangoInicio, int rangoFinal) {

		if (rangoInicio < rangoFinal) {
			return autorDao.buscarAutor(rangoInicio, rangoFinal);
		} else {
			return autorDao.buscarAutor(rangoFinal, rangoInicio);
		}// fin del if 

	}// fin del List<Autor> buscarAutores

}// fin de AutorBusiness 
