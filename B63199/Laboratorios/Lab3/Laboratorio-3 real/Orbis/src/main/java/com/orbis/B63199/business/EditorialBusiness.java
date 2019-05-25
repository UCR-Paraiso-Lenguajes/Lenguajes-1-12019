package com.orbis.B63199.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.B63199.data.EditorialData;
import com.orbis.B63199.domain.Editorial;

@Service
public class EditorialBusiness {

	@Autowired
	private EditorialData editorialData;

	public List<Editorial> obtenerEditorial() {
		return editorialData.buscarEditoriales();
	}
}
