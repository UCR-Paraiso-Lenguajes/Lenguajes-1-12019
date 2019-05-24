package com.proyectoUno.grupo5.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoUno.grupo5.business.UserBusiness;
import com.proyectoUno.grupo5.dao.NotificationService;
import com.proyectoUno.grupo5.domain.Role;
import com.proyectoUno.grupo5.domain.User;

@Controller
public class IngresoController {

	
	 @Autowired
	 private NotificationService notificationService;
	 @Autowired
	private UserBusiness userBusiness;
	
	 ArrayList<Role> roles = new ArrayList<Role>(); 
 	Role roleUser = new Role(3, "room_user");
	 
    @RequestMapping(value = "/ingreso", method = RequestMethod.GET)
    public String ingreso(Model model,@ModelAttribute(name="user") User user){
    	
    	
    	
        return "ingreso";
    }
    @RequestMapping(value="/ingreso", method=RequestMethod.POST)
    public String ingreso(@ModelAttribute(name="user") User user, Model model) {
    	
    	
    	roles.add(roleUser);
    	user.setEmail(user.getEmail());
    	user.setHash("url");
    	user.setRoleUser(roles);
    	userBusiness.insertUser(user);
    	try {
    		notificationService.sendNotification(user);
    		
    	}catch(MailException e) {
    		//catch error
    	}
    	
    	return "correoExitoso";
    }
    
    
    
    
}

