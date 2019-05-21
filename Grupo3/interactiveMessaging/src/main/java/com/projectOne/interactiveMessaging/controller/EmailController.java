package com.projectOne.interactiveMessaging.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectOne.interactiveMessaging.bussines.EmailBussines;


@Controller
public class EmailController {

	  @Autowired
	    private EmailBussines emailBussines;

	    @GetMapping("/")
	    public String index(){
	        return "send_mail_view";
	    }

	    @PostMapping("/sendMail")
	    public String sendMail( @RequestParam("mail") String mail){

	       emailBussines.sendMail("soporte.soft.inc@gmail.com",mail,"Invitacion","te invitamos por medio de este link:   ");

	        return "send_mail_view";
	    }
	
}




