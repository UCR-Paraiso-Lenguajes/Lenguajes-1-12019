package com.orbis.b63817.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orbis.b63817.dominio.Editorial;
import com.orbis.b63817.logica.EditorialLogica;

@Controller
public class EditorialControlador {
	@Autowired
	private EditorialLogica editorialLogica;
	
	@RequestMapping(value="/listarEditorial", method=RequestMethod.GET )
	public String iniciar(Model model) {
		//TODO capturar los parámetros remitidos desde la vista
		model.addAttribute("editoriales", editorialLogica.listarEditoriales(1,2));
		return "listarEditorial";
	}
	
	
	@RequestMapping(value="/editoriales", method=RequestMethod.GET )
	public @ResponseBody List<Editorial> buscarPorCantidad(Model model) {
		return editorialLogica.listarEditoriales(1,2);
	}	
}
