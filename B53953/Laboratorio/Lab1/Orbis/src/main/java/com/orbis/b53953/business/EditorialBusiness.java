package com.orbis.b53953.business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b53953.data.EditorialData;
import com.orbis.b53953.domain.Editorial;

@Service
public class EditorialBusiness {
	
	@Autowired
	private EditorialData editorialaDao;
	
	public List<Editorial> encontrarEditoriales(int cod) {
		return editorialaDao.encontrarEditoriales(cod);
}

}
