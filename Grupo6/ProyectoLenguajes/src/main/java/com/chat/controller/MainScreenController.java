package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
}
