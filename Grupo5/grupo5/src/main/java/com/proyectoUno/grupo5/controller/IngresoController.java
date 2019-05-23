package com.proyectoUno.grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoUno.grupo5.dao.NotificationService;
import com.proyectoUno.grupo5.domain.User;

@Controller
public class IngresoController {

	
	 @Autowired
	 private NotificationService notificationService;
	
	
    @RequestMapping(value = "/ingreso", method = RequestMethod.GET)
    public String ingreso(Model model,@ModelAttribute(name="user") User user){
    	
    	
    	
        return "ingreso";
    }
    @RequestMapping(value="/ingreso", method=RequestMethod.POST)
    public String ingreso(@ModelAttribute(name="user") User user, Model model) {
    	
    	
    	user.setEmail(user.getEmail());
    	System.out.print("Correo enviado");
    	
    	try {
    		notificationService.sendNotification(user);
    	
    	}catch(MailException e) {
    		//catch error
    	}
    	
    	return "correoExitoso";
    }
    
    
    
    
}

