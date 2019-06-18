package com.orbis.b54524.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b54524.business.EditorialBusiness;
import com.orbis.b54524.business.LibroBusiness;
import com.orbis.b54524.dominio.Editorial;

@Controller
public class libroControlador {
	
	@Autowired
	private EditorialBusiness editorialBusiness;
	@Autowired
	private LibroBusiness libroBusiness;
	
	
	@RequestMapping(value="/ver_editoriales", method=RequestMethod.GET)
	public String iniciar(Model model) {
		
		model.addAttribute("editoriales", editorialBusiness.listarEditoriales(1, 10));
		return "ver_editoriales";
	}
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET)
	public String buscarPorEditorial(Model model, @RequestParam("idEditorial") int idEditorial) {
		model.addAttribute("libros", libroBusiness.listarLibros(1, 10, idEditorial));
		return "mostrar_libros";
	}
}
