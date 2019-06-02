package com.videcartago.renting.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String root(){
		return "helloworld";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		return "helloworld";
	}
	
	@RequestMapping(value="/adminHome", method=RequestMethod.GET)
	public String adminHome(HttpServletRequest  request){
		
		//request.getSession().setAttribute("saldo", 200); Ejemplo de acceder a la asesion
		
		return "adminHome";
	}
		
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		
		//TODO destruir la sesion.
		
		return "login";
	}
	
	@RequestMapping(value="/accessDenied", method=RequestMethod.GET)
	public String accessDenied(){
			
		return "403";
	}
	
}

