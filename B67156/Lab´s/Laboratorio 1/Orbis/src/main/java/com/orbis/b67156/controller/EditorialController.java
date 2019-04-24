package com.orbis.b67156.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b67156.business.EditorialBusiness;
import com.orbis.b67156.domain.Editorial;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/VerEditoriales",method=RequestMethod.GET)
	public String iniciar(Model model) {
		return "VerEditoriales";
	}
	
	@RequestMapping(value="/VerEditoriales",method=RequestMethod.POST)
	public String encuentraEditorial (Model model, @RequestParam("id_editorial") String id_Editorial) {
		int id_editorial_int = Integer.parseInt(id_Editorial);
		Iterator<Editorial> editoriales = editorialBusiness.buscarPorId(id_editorial_int);
		model.addAttribute("editorial", editoriales);
		return "VerEditoriales";
	}
	
	@RequestMapping(value="/VerRangoEditoriales",method=RequestMethod.POST)
	public String encuentraEditorialRango (Model model, @RequestParam("rangoUno") String id_Edit_Uno,@RequestParam("rangoDos") String id_Edit_Dos) {
		int id_edit_Rango_Uno = Integer.parseInt(id_Edit_Uno);
		int id_edit_Rango_Dos = Integer.parseInt(id_Edit_Dos);
		Iterator<Editorial> editoriales = editorialBusiness.buscarPorRango(id_edit_Rango_Uno, id_edit_Rango_Dos);
		model.addAttribute("editorial", editoriales);
		return "VerEditoriales";
	}

}
