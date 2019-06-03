package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.bussines.ChatRoomBussines;

@Controller
public class MetricsController {

	@Autowired
	private ChatRoomBussines roomBusiness;

	
	@RequestMapping(value="/metric", method=RequestMethod.GET)
    public String metric(Model model) 
	{
		model.addAttribute("rooms", roomBusiness.getRooms());
		return "metric";
    }
	
	

	@RequestMapping(value = "/metric2", method = RequestMethod.GET)
	public String metric2(Model model) {
		return "metric2";
	}

}
