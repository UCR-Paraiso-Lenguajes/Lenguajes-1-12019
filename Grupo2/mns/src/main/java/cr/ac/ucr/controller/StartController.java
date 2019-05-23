package cr.ac.ucr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

	@RequestMapping(value="/a", method=RequestMethod.GET )
	public String start(Model model) {
		
		return "start";
	}
	
}
