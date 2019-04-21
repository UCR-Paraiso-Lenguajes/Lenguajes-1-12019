package com.orbis.b67156.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b67156.data.EditorialData;
import com.orbis.b67156.domain.Editorial;
@Service
public class EditorialBusiness {
	
	@Autowired
	private EditorialData editorialDao;
	
	public Iterator<Editorial> buscarPorId(int id_editorial) {
		return editorialDao.buscarPorEditorial(id_editorial);
	}
	
	public Iterator<Editorial> buscarPorRango(int id_edit_Uno, int id_edit_Dos) {
		return editorialDao.buscarPorBloque(id_edit_Uno,id_edit_Dos);
	}

}
