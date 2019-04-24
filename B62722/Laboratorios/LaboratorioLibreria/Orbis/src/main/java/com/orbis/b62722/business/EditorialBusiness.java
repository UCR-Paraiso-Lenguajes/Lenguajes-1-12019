package com.orbis.b62722.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b62722.data.EditorialData;
import com.orbis.b62722.domain.Editorial;

@Service
public class EditorialBusiness {

	@Autowired
	private EditorialData editorialData;
	
	public List<Editorial> buscarEditorial() {
		return editorialData.buscarEditorial();
	}
}
