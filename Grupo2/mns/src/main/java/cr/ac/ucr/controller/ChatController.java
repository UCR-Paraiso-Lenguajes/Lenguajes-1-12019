package cr.ac.ucr.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.business.RoomBusiness;
import cr.ac.ucr.domain.Message;

@Controller
public class ChatController {


	@Autowired
	private RoomBusiness roomBusiness;
	

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String showMessagesOnRoom(Model model)  {
		
		Iterator<Message> messages = roomBusiness.listMessages();
		
		model.addAttribute("messages", messages);
		
		
		return "chat";
	}
	
	
}
