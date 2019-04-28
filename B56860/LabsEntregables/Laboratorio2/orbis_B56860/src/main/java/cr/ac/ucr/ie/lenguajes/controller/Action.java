package cr.ac.ucr.ie.lenguajes.controller;

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


import cr.ac.ucr.ie.lenguajes.business.AutoresBusiness;
import cr.ac.ucr.ie.lenguajes.business.EditorialBusiness;
import cr.ac.ucr.ie.lenguajes.business.LibroBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Autor;
import cr.ac.ucr.ie.lenguajes.domain.Editorial;
import cr.ac.ucr.ie.lenguajes.domain.Libro;
import cr.ac.ucr.ie.lenguajes.form.LibroForm;

@Controller
public class Action {
	
	@Autowired
	EditorialBusiness editorialBusiness;
	@Autowired
	AutoresBusiness autoresBusiness;
	@Autowired
	LibroBusiness libroBusiness;
	@Autowired
	EditorialController editorialController;
	
	@RequestMapping(value="/insertarLibro",method=RequestMethod.GET)
	public String insertar(LibroForm libroForm,Model model) throws SQLException {
		
		List<Editorial> editoriales = editorialBusiness.ListarEditoriales(1,4);
		List<Autor> autores = autoresBusiness.ListarAutores(1, 4);
		
		model.addAttribute("editoriales",editoriales);
		model.addAttribute("autores",autores);
		model.addAttribute("libroForm",libroForm);
		
		return "insertarLibro";
	}

	@RequestMapping(value="/insertarLibro",method=RequestMethod.POST)
	public String guardar(@Valid LibroForm libroForm,BindingResult bindingResult,Model model) throws SQLException {
	
		
		if(bindingResult.hasErrors()) {
			return insertar(libroForm,model);
			//return ""+bindingResult.getFieldError();
		}
		else {
			Libro libro = new Libro();
	        BeanUtils.copyProperties(libroForm, libro);
	        libro.getEditorial().setId_editorial(libroForm.getId_editorial());
	        
	        libroBusiness.save(libro);

	        return editorialController.librosporEdi(model,libroForm.getId_editorial());
		}
	}
}
