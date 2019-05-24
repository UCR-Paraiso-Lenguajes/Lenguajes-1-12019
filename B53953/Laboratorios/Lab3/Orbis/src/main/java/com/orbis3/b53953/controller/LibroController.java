package com.orbis3.b53953.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis3.b53953.business.EditorialBusiness;
import com.orbis3.b53953.business.LibroBusiness;
import com.orbis3.b53953.data.LibroForm;
import com.orbis3.b53953.domain.Libro;

@Controller
public class LibroController {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;

	@RequestMapping(value = "/libros", method = RequestMethod.GET)
	public String listarLibros(Model model, @RequestParam("idLib") int editorialId) {
		model.addAttribute("Libros", libroBusiness.obtenerLibrosPorEditorial(editorialId));
		return "Libros";
	}

	@RequestMapping(value = "/insertarlibro", method = RequestMethod.GET)
	public String insertarLibros(LibroForm libroForm, Model model) {
		model.addAttribute("Editoriales", editorialBusiness.obtenerEditorial());
		model.addAttribute("Autores", libroBusiness.obtenerAutores());
		model.addAttribute("form", libroForm);
		return "InsertarLibro";
	}

	@RequestMapping(value = "/insertarlibro", method = RequestMethod.POST)
	public String guardarLibro(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors())
			return insertarLibros(libroForm, model);
		Libro libro = new Libro();
		BeanUtils.copyProperties(libroForm, libro);
		libro.getEditorial().setId(libroForm.getIdEditorial());
		return libroBusiness.guardar(libro, libroForm.getIdAutores()) ? exitoInsertar(model) : errorInsertar(model);
	}

	@RequestMapping(value = "/errorinsertarlibro", method = RequestMethod.GET)
	private String errorInsertar(Model model) {
		return "ErrorInsertarLibro";
	}

	@RequestMapping(value = "/exitoinsertarlibro", method = RequestMethod.GET)
	private String exitoInsertar(Model model) {
		return "ExitoInsertarLibro";
	}
}
