package com.orbis.b63685.Laboratorio2Orbis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b63685.Laboratorio2Orbis.business.EditorialBusiness;
import com.orbis.b63685.Laboratorio2Orbis.business.LibroBusiness;

@Controller
public class LibroController {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/verEditoriales", method=RequestMethod.GET)
	public String iniciar(Model model) {
		model.addAttribute("editoriales", editorialBusiness.listarEditoriales());
		return "lista_editoriales";
	}
	
	@RequestMapping(value="/lista_libros", method=RequestMethod.GET)
	public String mostrar(Model model, @RequestParam("idEditorial") int idEditorial) {
		model.addAttribute("libros", libroBusiness.encontrarLibro(idEditorial));

		return "lista_libros";
	}
	@RequestMapping(value = "/insertarLibro", method = RequestMethod.GET)
	public String insertar(Model model, LibroForm libroForm) {

		List<Editorial> editoriales = editorialBusiness.listarEditoriales();

		model.addAttribute("editoriales", editoriales);
		model.addAttribute("libroform", new LibroForm());
		return "insertarLibro";
	}

	@RequestMapping(value = "/insertarLibro", method = RequestMethod.POST)
	public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws SQLException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("editoriales", editorialBusiness.listarEditoriales());
			return "error";
		} else {
			
			LinkedList<Autor> autores = new LinkedList<Autor>();
			LinkedList<Libro> libros = new LinkedList<Libro>();
			
			Editorial editorial = new Editorial(1345, "Prentice hall", "cartaga", "768756");
			Libro libro = new Libro(3344556, "hola", (short)1997, 23456, autores, editorial);
			
			
			
			BeanUtils.copyProperties(libroForm, libro);
			libro.getEditorial().setIdEditorial(libroForm.getEditorial().getIdEditorial());
			libroBusiness.save(libro);

			return "exito";
		}
	}

	
}
