package com.orbis.b63817.ventas.controlador;



import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orbis.b63817.ventas.dominio.Editorial;
import com.orbis.b63817.ventas.logica.EditorialLogica;


@Controller
public class EditorialControlador {
	@Autowired
private EditorialLogica editorialBusiness;
	
	@RequestMapping(value="/listarEditoriales", method=RequestMethod.GET )
	public String listarEditoriales(Model model) {
	Iterator<Editorial> listaEditorial = editorialBusiness.listarEditoriales(1, 4);
		//TODO capturar los parámetros remitidos desde la vista
		model.addAttribute("listaEditorial", listaEditorial);
		
		return "listarEditoriales";
	}
	
	
	
}

