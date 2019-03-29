package cr.ac.ucr.ie.lenguajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.ac.ucr.ie.lenguajes.business.EditorialBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Editorial;
@Controller
public class EditorialController {
	@Autowired
	EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String iniciar(Model model) {
		List<Editorial> editoriales = editorialBusiness.ListarEditoriales(1, 3);
		model.addAttribute("editoriales",editoriales);
		return "verEditoriales";
	}
	
}
