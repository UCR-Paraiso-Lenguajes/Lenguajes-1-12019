package com.orbis.b62734.Laboratorio1Orbis.controller;

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

import com.orbis.b62734.Laboratorio1Orbis.business.EditorialBusiness;
import com.orbis.b62734.Laboratorio1Orbis.business.LibroBusiness;
import com.orbis.b62734.Laboratorio1Orbis.form.LibroForm;
import com.orbis.b62734.Laboratorio1Orbis.domain.*;

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
	
	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET)
    public String insertar(Model model, LibroForm libroForm) {
  
  List<Editorial> editoriales =  editorialBusiness.listarEditoriales();
  
  model.addAttribute("editoriales",editoriales);
  model.addAttribute("libroform",new LibroForm()); 
        return "insertarLibro";
    }
 
 @RequestMapping(value = "/insertarLibro", method = RequestMethod.POST)
 public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws SQLException {
  if (bindingResult.hasErrors()) {
   model.addAttribute("editoriales", editorialBusiness.listarEditoriales());
   return "error";
  } else {
   Libro libro = new Libro();
   BeanUtils.copyProperties(libroForm, libro);
   libro.getEditorial().setIdEditorial(libroForm.getEditorial().getIdEditorial());
   libroBusiness.save(libro);

   return "exito";
  }
 }

	
}
