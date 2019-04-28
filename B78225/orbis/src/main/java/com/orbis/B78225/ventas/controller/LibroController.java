package com.orbis.B78225.ventas.controller;

import com.orbis.B78225.ventas.business.AutorBusiness;
import com.orbis.B78225.ventas.business.EditorialBusiness;
import com.orbis.B78225.ventas.business.LibroBusiness;
import form.LibroForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibroController {

    @Autowired
    private AutorBusiness autorBusiness;

    @Autowired
    private EditorialBusiness editorialBusiness;

    @RequestMapping(value = "/insertarLibro", method = RequestMethod.GET)
    public String insertarLibro(LibroForm libroForm, Model model) {
        model.addAttribute("autores", autorBusiness.listarAutor(0,99999999));
        model.addAttribute("editoriales", editorialBusiness.listarEditorial(0,999999));
        model.addAttribute("editorialForm", new LibroForm());
        return "insertarLibro";
    }
    
    
}