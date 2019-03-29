package com.orbis.b66851.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b66851.ventas.data.EditorialData;
import com.orbis.b66851.ventas.domain.Editorial;

@Service
public class EditorialBusiness {
	@Autowired
	private EditorialData editorialdata;

	public List<Editorial> findAll() {
		return editorialdata.findAll();
	}

	
}
