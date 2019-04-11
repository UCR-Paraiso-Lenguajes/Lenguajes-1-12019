package com.orbis.B70620.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B70620.ventas.data.EditorialData;
import com.orbis.B70620.ventas.domain.Editorial;

@Service
public class EditorialBusiness {

	@Autowired
	private EditorialData editorialData;
	
	public List<Editorial> obtenerEditorial(){
		return editorialData.buscarEditoriales();
	}
}
