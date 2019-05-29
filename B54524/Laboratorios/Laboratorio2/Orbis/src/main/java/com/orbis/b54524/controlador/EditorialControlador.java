package com.orbis.b54524.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b54524.business.EditorialBusiness;


@Controller
public class EditorialControlador {

	@Autowired
	private EditorialBusiness editorialBusiness;

	@RequestMapping(value = "/encontrarEditoriales", method = RequestMethod.GET)
	public String encontrarEditorial(Model model) {
		model.addAttribute("editoriales", editorialBusiness.listarEditoriales(0, 50));
		return "verEditoriales";
	}

}
