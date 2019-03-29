package com.orbis.B52265.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B52265.dao.EditorialDao;
import com.orbis.B52265.domain.Editorial;
@Service
public class EditorialBusiness {
	@Autowired
	private EditorialDao editorial;

	public List<Editorial> getEditorial(int numero, int next) {
		return editorial.getEditoriales(numero,next);
	}
}
