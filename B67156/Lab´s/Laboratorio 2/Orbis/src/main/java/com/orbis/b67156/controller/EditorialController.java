package com.orbis.b67156.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b67156.business.EditorialBusiness;
import com.orbis.b67156.data.EditorialData;
import com.orbis.b67156.domain.Editorial;

@Controller
public class EditorialController {
	
	@Autowired
	private EditorialBusiness editorialBusiness;
	@Autowired
	private EditorialData editorialData;
	
	@RequestMapping(value="/VerEditoriales",method=RequestMethod.GET)
	public String iniciar(Model model) {
		return "VerEditoriales";
	}
	
//	@RequestMapping(value="/VerEditoriales",method=RequestMethod.POST)
//	public String encuentraEditorial (Model model, @RequestParam("id_editorial") String id_Editorial) {
//		int id_editorial_int = Integer.parseInt(id_Editorial);
//		Iterator<Editorial> editoriales = editorialBusiness.buscarPorId(id_editorial_int);
//		model.addAttribute("editorial", editoriales);
//		return "VerEditoriales";
//	}
	
	@RequestMapping(value="/VerEditoriales",method=RequestMethod.POST)
	public String ver_editoriales(Model model, @RequestParam("id_editorial") String id_editorial, @RequestParam("inicio") String inicio,
			@RequestParam("fin") String fin) {
		
		try {
			if(inicio.equals("")&&fin.equals("")&&!id_editorial.equals("")) {
		
				model.addAttribute("verEditoriales", editorialData.buscarPorEditorial(Integer.parseInt(id_editorial)));
		
		
			}else if(id_editorial.equals("")&&!inicio.equals("")&&!fin.equals("")){
				model.addAttribute("verEditoriales", editorialData.buscarPorBloque(Integer.parseInt(inicio), Integer.parseInt(fin)));
			}
	}catch(NumberFormatException ie){
		return "verEditoriales";
	}
		
	return "VerEditoriales";
	}

}
