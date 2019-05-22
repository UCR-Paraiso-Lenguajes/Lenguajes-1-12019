package com.projectOne.interactiveMessaging.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectOne.interactiveMessaging.bussines.EmailBussines;

@Controller
public class HelloController {

	@Autowired
    private EmailBussines emailBussines;
	
	@RequestMapping("/")
    public String login() {
        return "loginAdmi";
    }
	
	@RequestMapping("/signIn")
    public String signIn() {
        return "loginUser";
    }

    @PostMapping("/signIn")
    public String sendMail( @RequestParam("email") String mail){

       emailBussines.sendMail("soporte.soft.inc@gmail.com",mail,"Invitacion","te invitamos por medio de este link:   ");

        return "loginUser";
    }
	
	@RequestMapping("/chat")
    public String chat() {
        return "chat";
    }
	
	@RequestMapping("/chatSetting")
    public String chatSetting() {
        return "setting";
    }
}
