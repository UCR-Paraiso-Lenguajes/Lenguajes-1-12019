package com.orbis.b53953.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.orbis.b53953.domain.Editorial;


import com.orbis.b53953.business.EditorialBusiness;

@Controller
public class EditorialController {

	
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String encontrarEditoriales(Model model) {
		
		model.addAttribute("editoriales", editorialBusiness.encontrarEditoriales(102));
		return "encontrarEditoriales";
	}
	
	
	@RequestMapping(value="/encontrarEditoriales", method=RequestMethod.GET )
	public @ResponseBody List<Editorial> datos(Model model) {
		return editorialBusiness.encontrarEditoriales(102);
} 
	
		

}
