package com.orbis.b63685.Laboratorio2Orbis.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63685.Laboratorio2Orbis.data.EditorialDao;
import com.orbis.b63685.Laboratorio2Orbis.domain.Editorial;



@Service
public class EditorialBusiness {

	@Autowired
	private EditorialDao editorialDao;
	
	public List<Editorial> listarEditoriales(){
		return editorialDao.buscarEditoriales();
	}
}

