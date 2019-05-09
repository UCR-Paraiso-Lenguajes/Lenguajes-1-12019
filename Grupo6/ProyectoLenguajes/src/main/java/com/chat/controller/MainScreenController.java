package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainScreenController {

	@RequestMapping(value="/mainScreen", method=RequestMethod.GET)
    public String mainScreen(Model model) 
	{
	
		return "mainScreen";
    }
	
}
