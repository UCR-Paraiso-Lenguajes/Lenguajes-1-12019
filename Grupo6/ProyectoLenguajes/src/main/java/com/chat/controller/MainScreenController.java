package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.bussines.ChatRoomBussines;

@Controller
public class MainScreenController {
	
	@Autowired
	private ChatRoomBussines roomBusiness;

	@RequestMapping(value="/mainScreen", method=RequestMethod.GET)
    public String mainScreen(Model model) 
	{
		model.addAttribute("rooms", roomBusiness.getRooms());
		return "mainScreen";
    }
	
	@RequestMapping(value="/mainScreen/guess/{email}/{idRoom}", method=RequestMethod.GET)
    public String mainSreenguess(Model model, @PathVariable(value="email") String email, @PathVariable(value="idRoom") int room) 
	{
		model.addAttribute("rooms", roomBusiness.getRoomsByGuess(email, room));
		return "mainScreen";
    }
	
}
