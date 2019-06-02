package com.orbis.B63199.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.orbis.B63199.business.EditorialBusiness;

@Controller
public class EditorialController {
	@Autowired
	private EditorialBusiness editorialBusinness;

	@RequestMapping(value = "/ver_editoriales", method = RequestMethod.GET)
	public String buscarEditorial(Model model) {
		model.addAttribute("editoriales", editorialBusinness.obtenerEditorial());
		return "Editoriales";
	}
}
