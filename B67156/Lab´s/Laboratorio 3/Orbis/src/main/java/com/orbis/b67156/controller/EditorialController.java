package com.orbis.b67156.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b67156.data.EditorialData;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialData editorialNegocios;
	
	@RequestMapping(value="/verEditoriales", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "verEditoriales";
	}
	
	@RequestMapping(value="/verEditoriales", method=RequestMethod.POST )
	public String ver_editoriales(Model model, @RequestParam("id_editorial") String id_editorial,
			@RequestParam("inicio") String inicio, @RequestParam("fin") String fin) {
		try {
			if(inicio.equals("")&&fin.equals("")&&!id_editorial.equals("")) {
		
				model.addAttribute("verEditoriales", editorialNegocios.searchPorEditorialID(Integer.parseInt(id_editorial)));
		
		
			}else if(id_editorial.equals("")&&!inicio.equals("")&&!fin.equals("")){
				model.addAttribute("verEditoriales", editorialNegocios.searchPorEditorialRango(Integer.parseInt(inicio), Integer.parseInt(fin)));
			}
	}catch(NumberFormatException ie){
		return "verEditoriales";
	}

		
		return "verEditoriales";
	}

}

