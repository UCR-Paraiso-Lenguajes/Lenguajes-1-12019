package com.projectOne.interactiveMessaging.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	//enviar correos a varias personas 
	@GetMapping("/multipleMessages")
    public String index(){
        return "multipleMessages";
    }

    @RequestMapping(value="/sendMail", method=RequestMethod.POST )
    public String sendMail(@RequestParam("select") String [] correos){

    	
    	for (int i = 0; i < correos.length; i++) {
    		emailBussines.sendMail("soporte.soft.inc@gmail.com",correos[i],"hola","sirvio");
    	}
       //mailService.sendMail("soporte.soft.inc@gmail.com",mail,subject,body);

        return "multipleMessages";
    }
  //fin enviar correos a varias personas 
	
}
