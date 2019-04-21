package com.orbis.B74560.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.B74560.data.EditorialData;
import com.orbis.B74560.exception.ExceptionsOrbi;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialData editorialDao;
	
	@RequestMapping(value="/ver_Editoriales", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "ver_Editoriales";
	}
	
	@RequestMapping(value="/ver_Editoriales", method=RequestMethod.POST )
	public String ver_editoriales(Model model, @RequestParam("id_editorial") String id_editorial){
		
		
		int id_editorialNumero = Integer.parseInt(id_editorial);
		if(id_editorialNumero<=0) {
			throw new ExceptionsOrbi("Solo puede ingresar numeros");
		}else {
			model.addAttribute("editorial", editorialDao.buscarPorEditorial(id_editorialNumero));
			return "ver_Editoriales";
		}

		
	}
}// public class

