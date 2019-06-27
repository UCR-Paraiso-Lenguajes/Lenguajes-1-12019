package com.orbis.b62734.Laboratorio1Orbis.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b62734.Laboratorio1Orbis.data.EditorialDao;
import com.orbis.b62734.Laboratorio1Orbis.domain.Editorial;



@Service
public class EditorialBusiness {

	@Autowired
	private EditorialDao editorialDao;
	
	public List<Editorial> listarEditoriales(){
		return editorialDao.buscarEditoriales();
	}
}

