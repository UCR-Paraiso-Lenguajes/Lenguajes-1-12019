package cr.ac.ucr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.business.UserBusiness;


@Controller
public class UserController {
	
	@Autowired
	private UserBusiness userBusiness;

	
	@RequestMapping(value="/Usuarios", method=RequestMethod.GET )
	public String usuarios(Model model) {
		model.addAttribute("usuarios", userBusiness.findUser());
		return "informacion";
}
	
	
}
