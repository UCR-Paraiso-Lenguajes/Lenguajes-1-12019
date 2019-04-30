package com.orbis.b53953.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b53953.data.EditorialData;
import com.orbis.b53953.domain.Editorial;

@Service
public class EditorialBusiness {
	
	@Autowired
	private EditorialData editorialaData;
	
	public List<Editorial> encontrarEditoriales() {
		return editorialaData.encontrarEditoriales();
}

}
