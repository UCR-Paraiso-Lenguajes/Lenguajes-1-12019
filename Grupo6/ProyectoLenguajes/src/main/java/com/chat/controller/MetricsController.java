package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MetricsController {

	@RequestMapping(value="/metric", method=RequestMethod.GET)
    public String metric(Model model) 
	{
	
		return "metric";
    }
	
	@RequestMapping(value="/metric2", method=RequestMethod.GET)
    public String metric2(Model model) 
	{
	
		return "metric2";
    }
	
}
