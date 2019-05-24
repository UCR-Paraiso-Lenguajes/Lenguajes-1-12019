package com.orbis.B77436.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B77436.data.EditorialData;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialData editorialBusiness;
	
	@RequestMapping(value="/ver_editoriales", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "ver_editoriales";
	}
	
	@RequestMapping(value="/ver_editoriales", method=RequestMethod.POST )
	public String ver_editoriales(Model model, @RequestParam("id_editorial") String id_editorial,
			@RequestParam("rango1") String rango1, @RequestParam("rango2") String rango2) {
		
		if(rango1.equals("")&&rango2.equals("")&&!id_editorial.equals("")) {
		
			model.addAttribute("editorial", editorialBusiness.buscarPorId(Integer.parseInt(id_editorial)));
		
		}else if(id_editorial.equals("")&&!rango1.equals("")&&!rango2.equals("")){
			model.addAttribute("editorial", editorialBusiness.buscarPorExtracto(Integer.parseInt(rango1), Integer.parseInt(rango2)));
		}
		
		return "ver_editoriales";
	}
	
	

}
