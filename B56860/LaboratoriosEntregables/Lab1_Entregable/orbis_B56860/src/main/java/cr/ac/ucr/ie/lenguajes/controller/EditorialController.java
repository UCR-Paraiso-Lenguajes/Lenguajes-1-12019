package cr.ac.ucr.ie.lenguajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.ac.ucr.ie.lenguajes.business.EditorialBusiness;
@Controller
public class EditorialController {
	@Autowired
	EditorialBusiness editorialBusiness;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public @ResponseBody String iniciar(Model model) {
		return "verEditoriales";
	}
	
}
