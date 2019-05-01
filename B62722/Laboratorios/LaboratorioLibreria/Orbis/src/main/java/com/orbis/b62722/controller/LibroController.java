package com.orbis.b62722.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b62722.business.EditorialBusiness;
import com.orbis.b62722.business.LibroBusiness;
import com.orbis.b62722.domain.*;
import com.orbis.b62722.form.LibroForm;

@Controller
public class LibroController {

	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;

	@RequestMapping(value="/editoriales", method=RequestMethod.GET)
    public String iniciar(Model model) {
		model.addAttribute("editoriales",editorialBusiness.buscarEditorial());
        return "ver_editoriales";
    }
	
	@RequestMapping(value="/mostrar_libros", method=RequestMethod.GET)
	public String mostrar(Model model, @RequestParam("idEditorial") int idEditorial) {
		model.addAttribute("libros",libroBusiness.buscarLibro(idEditorial));
		return "mostrar_libros";
	}

	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET)
    public String insertar(Model model, LibroForm libroForm) {
		
		List<Editorial> editoriales =  editorialBusiness.buscarEditorial();
		
		//model.addAttribute("editoriales",editoriales);
		model.addAttribute("libroform",new LibroForm()); 
        return "insertarLibro";
    }
	
	@RequestMapping(value = "/insertarLibro", method = RequestMethod.POST)
	public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws SQLException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("editoriales", editorialBusiness.buscarEditorial());
			return "error";
		} else {
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.getEditorial().setId_editorial(libroForm.getEditorial().getId_editorial());
			libroBusiness.save(libro);

			return "exito";
		}
	}
}
