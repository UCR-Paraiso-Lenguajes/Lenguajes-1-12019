package com.orbis.b40894.ventas.business;
import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.b40894.ventas.data.EditorialData;
import com.orbis.b40894.ventas.domain.Editorial;

@Service
public class EditorialBusiness {
@Autowired
	private EditorialData editorialDao;
	
	public Iterator<Editorial> findEditorial(int cantidadInicio,int cantidadFin) {
		return editorialDao.findEditorial(cantidadInicio,cantidadFin);
	}
}



