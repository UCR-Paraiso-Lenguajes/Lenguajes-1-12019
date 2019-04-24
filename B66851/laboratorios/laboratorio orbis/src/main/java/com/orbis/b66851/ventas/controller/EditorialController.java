package com.orbis.b66851.ventas.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

	import com.orbis.b66851.ventas.business.EditorialBusiness;
import com.orbis.b66851.ventas.domain.Editorial;

	

	@Controller
	public class EditorialController {
		@Autowired
		private EditorialBusiness editorialBusiness;
		
		@RequestMapping(value="/verEditoriales", method=RequestMethod.GET )
		public String findMovies(Model model) {
			
			model.addAttribute("editoriales", editorialBusiness.findAll());
			return "ver_editoriales";
		}
		
		
		
}
