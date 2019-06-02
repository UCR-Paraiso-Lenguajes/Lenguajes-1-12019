package com.proyectoUno.grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoUno.grupo5.business.AdminBusiness;

import com.proyectoUno.grupo5.domain.Admin;


@Controller
public class AdminController {

	 @Autowired
		private AdminBusiness adminBusiness;
	
	
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
     	 
		 public String ingreso(Model model,@ModelAttribute(name="admin") Admin admin){
		       
     return "loginAdmin.html";
     }
	 
	 
	 @RequestMapping(value = "/admin", method = RequestMethod.POST)
 	 
	 public String principal(Model model,@ModelAttribute(name="admin") Admin admin){
		
		 
		 boolean validacion=adminBusiness.validacion(admin.getUsername(),admin.getPassword());
		 
		 if(validacion) {
		 return "correoExitoso";
		}else {
			 
			 return "loginAdmin";
		 }
		 

 }
	 
	 
}
