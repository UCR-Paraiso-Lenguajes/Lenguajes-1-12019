package com.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chat.bussines.UserBussines;
import com.chat.data.UserData;
import com.chat.domain.Rol;
import com.chat.domain.UserClient;


@Controller
public class LoginController {
	
	@Autowired
	UserBussines userBussines;

	@Autowired
	UserData userData;

	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model)
	{
		/*MetricData metricData = new MetricData();
		int cantidad=0;
		cantidad = metricData.getQuantityRooms();
		System.out.println(cantidad);*/
		
		

		return "login";
    }

	@RequestMapping(value="/login/validation", method=RequestMethod.POST)
    public String loginPostUserValidation(Model model,@RequestParam(name ="email") String email, HttpServletRequest servlet)
	{
		/*MetricData metricData = new MetricData();
		int cantidad=0;
		cantidad = metricData.getQuantityRooms();
		System.out.println(cantidad);*/
		HttpSession sesion = servlet.getSession();
		UserClient userClient = new UserClient();
		
		String User="user";
		Rol rolDomain = new Rol(1,"Client");
		
		userClient.setEmail(email);
		userClient.setRol(rolDomain);
		
		if(userBussines.existUser(userClient) == true) {
			
		}else {
		
		int userID = userData.addUserClient(userClient);
		
		userClient.setId(userID);
		
		}
		
		sesion.setAttribute(User, userClient);
		
		UserClient userSession = (UserClient)sesion.getAttribute("user");
		System.out.println("User que deberia estar en Sesion: "+userSession.toString());
		
		return "mainScreen";
    }

	
	@RequestMapping(value="/loginAdmin", method=RequestMethod.GET)
    public String loginAdmin(Model model)
	{
		return "loginAdmin";
    }

}
