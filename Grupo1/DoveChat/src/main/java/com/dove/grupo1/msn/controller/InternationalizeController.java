package com.dove.grupo1.msn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InternationalizeController {
 
	    @GetMapping("/loginUser")
	    public String getInternationalPage() {
	        return "loginUser";
	    }
	    
	    @GetMapping("/userChatRoom")
	    public String getInternationalPage2() {
	        return "userChatRoom";
	    }
	
}
