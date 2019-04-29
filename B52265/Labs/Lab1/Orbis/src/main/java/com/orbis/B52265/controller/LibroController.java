package com.orbis.B52265.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B52265.business.AutorBusiness;
import com.orbis.B52265.business.EditorialBusiness;
import com.orbis.B52265.business.LibroBusiness;
import com.orbis.B52265.domain.Editorial;
import com.orbis.B52265.domain.Libro;
import com.orbis.B52265.form.LibroForm;
@Controller
public class LibroController {

    @Autowired
    private AutorBusiness autorBusiness;
    
    @Autowired
    private EditorialBusiness editorialBusiness;
    
    @RequestMapping(value = "/insertarLibro", method = RequestMethod.GET)
    public String insertarLibro(LibroForm libroForm,Model model) {
    	model.addAttribute("autores", autorBusiness.listarAutores(0,99999999));
        model.addAttribute("editoriales", editorialBusiness.getEditorial(0,999999));
        model.addAttribute("editorialForm", new LibroForm());
		return "insertarLibro";
	}
}
