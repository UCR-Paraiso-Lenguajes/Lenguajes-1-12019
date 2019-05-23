package cr.ac.ucr.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.business.RecoverStateBusiness;
import cr.ac.ucr.business.RoomBusiness;
import cr.ac.ucr.domain.Message;

@Controller
public class ChatController {


	@Autowired
	private RoomBusiness roomBusiness;
	@Autowired
	private RecoverStateBusiness rsb;

	
	
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String showMessagesOnRoom(Model model)  {
		
		
			List<Message> messages = rsb.retrieveState(50);
			model.addAttribute("messages", messages);
		
		
		
		return "chat";
	}
	
	
}
