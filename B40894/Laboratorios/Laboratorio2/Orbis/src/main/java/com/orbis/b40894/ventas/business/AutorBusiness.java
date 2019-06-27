package com.orbis.b40894.ventas.business;
import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b40894.ventas.data.AutorData;
import com.orbis.b40894.ventas.domain.Autor;


@Service
public class AutorBusiness {
@Autowired
	private AutorData autorDao;
	
	public Iterator<Autor> findAllAutores() {
		return autorDao.findAllAutores();
	}
}



