package com.orbis.b53953.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b53953.domain.Editorial;


import com.orbis.b53953.business.EditorialBusiness;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/a", method=RequestMethod.GET )
	public String encontrarEditoriales(Model model) {
		
		model.addAttribute("editoriales", editorialBusiness.encontrarEditoriales());
		return "verEditoria";
	}
	
	
	@RequestMapping(value="/encontrarEditoriales", method=RequestMethod.GET )
	public String encontrarEditorial(Model model) {
		model.addAttribute("editoriales", editorialBusiness.encontrarEditoriales());
		return "verEditoriales";
} 
	
		

}
