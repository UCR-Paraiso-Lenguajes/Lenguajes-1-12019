package com.orbis.B52265.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B52265.business.EditorialBusiness;
import com.orbis.B52265.business.LibroBusiness;
import com.orbis.B52265.domain.Editorial;
import com.orbis.B52265.domain.Libro;

@Controller
public class EditorialController {
	@Autowired
	private EditorialBusiness editorial;
	@Autowired
	private LibroBusiness libro;

	public int pag = 1;
	public int next = pag + 2;
	private boolean isEmpty;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String verEditoriales(Model model) {
		List<Editorial> list = editorial.getEditorial(pag, next);
		model.addAttribute("editoriales", list);
		return "editoriales";
	}

	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String verEditorialesNext(Model model) {
		pag += 3;
		next += 3;
		List<Editorial> list = editorial.getEditorial(pag, next);
		model.addAttribute("editoriales", list);
		;
		return "editoriales";
	}

	@RequestMapping(value = "/prev", method = RequestMethod.GET)
	public String verEditorialesPrev(Model model) {
		pag -= 3;
		next -= 3;
		List<Editorial> list = editorial.getEditorial(pag, next);
		model.addAttribute("editoriales", list);
		;
		return "editoriales";
	}

	@RequestMapping(value = "/libros", method = RequestMethod.GET)
	public String verLibros(@RequestParam("id") int id, Model model) {
		List<Libro> list = libro.getLibros(id);
		isEmpty = list.isEmpty() ? true:false;
		model.addAttribute("libros", list);
		model.addAttribute("isEmpty", isEmpty);
		return "libros";
	}

}
