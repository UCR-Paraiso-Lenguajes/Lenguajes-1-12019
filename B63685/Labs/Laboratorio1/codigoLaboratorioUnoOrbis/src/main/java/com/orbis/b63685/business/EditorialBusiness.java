package com.orbis.b63685.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b63685.data.EditorialData;
import com.orbis.b63685.data.LibroData;
import com.orbis.b63685.domain.Editorial;
import com.orbis.b63685.domain.Libro;

@Service
public class EditorialBusiness {

	@Autowired
	private EditorialData editorialData;
	
	public List<Editorial> listarEditoriales(){
		return editorialData.listarEditoriales();
	}
}
