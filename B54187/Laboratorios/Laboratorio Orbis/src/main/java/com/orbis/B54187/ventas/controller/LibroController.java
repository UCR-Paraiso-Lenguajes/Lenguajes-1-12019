package com.orbis.B54187.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B54187.ventas.business.EditorialBusiness;
import com.orbis.B54187.ventas.business.LibroBusiness;

@Controller
public class LibroController {
	@Autowired
	private EditorialBusiness editorialBusiness;
	//@Autowired
	//private LibroBusiness libroBusiness;
	
	@RequestMapping(value = "/mostrarEditoriales", method = RequestMethod.GET)
	public String iniciar(Model model) {
		model.addAttribute("editoriales", editorialBusiness.mostrarEditorial());
		return "ver_editoriales";
	}
	
	//@RequestMapping(value = "/mostrarLibros", method = RequestMethod.GET)
	//public String mostrar(Model model, @RequestParam("idEditorial") int idEditorial, @RequestParam("nombre") String nombre) {
		//model.addAttribute("libro",libroBusiness.mostrarLibro(idEditorial));
		//model.addAttribute("nombre",nombre);
		//return "mostrar_libros";
	//}
	
}
