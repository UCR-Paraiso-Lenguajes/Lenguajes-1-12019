package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chat.data.ChatRomData;
import com.chat.data.MetricDat;
import com.chat.domain.ChatRoom;


@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) 
	{		
		return "login";
    }
	
	@RequestMapping(value="/loginAdmin", method=RequestMethod.GET)
    public String loginAdmin(Model model) 
	{
		return "loginAdmin";
    }
	
}
