package cr.ac.ucr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cr.ac.ucr.business.RecoverStateBusiness;
import cr.ac.ucr.business.RoomBusiness;
import cr.ac.ucr.domain.Message;
import cr.ac.ucr.form.MessageForm;

@Controller
public class ChatController {


	@Autowired
	private RoomBusiness roomBusiness;
	@Autowired
	private RecoverStateBusiness rsb;
	
	
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	public String processMessage(Model model,@RequestBody MessageForm message)  {
		
		
		
		
		return "chat";
	}
	
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String showMessagesOnRoom(Model model)  {
		
		
			model.addAttribute("rooms", roomBusiness.staticRooms);
			
		
			List<Message> messages = rsb.retrieveState(50);
			model.addAttribute("messages", messages);
		
		
		
		return "chat";
	}
	
	
}
