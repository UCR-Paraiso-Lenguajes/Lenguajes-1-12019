package cr.ac.ucr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RoomController {



	@RequestMapping(value = "/createEmptyRoom", method = RequestMethod.GET)
	public String showFormEmptyRoom(Model model)  {
			return "createEmptyRoom";
	}
	
	
	@RequestMapping(value = "/createRoom", method = RequestMethod.GET)
	public String showForm(Model model)  {
			return "createRoom";
	}
	
	
}
	