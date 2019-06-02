package com.orbis.B54187.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B54187.ventas.data.EditorialData;
import com.orbis.B54187.ventas.domain.Editorial;



@Service
	public class EditorialBusiness {
		@Autowired
		private EditorialData editorialdata;

		public List<Editorial> mostrarEditorial() {
			return editorialdata.mostrarEditorial();
	}
}
