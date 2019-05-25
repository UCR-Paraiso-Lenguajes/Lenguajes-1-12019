package com.chat.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.domain.UserAdmin;

@RestController
public class LoginAdminControllerRest {
	
	@RequestMapping(value="api/LoginAdmin", method=RequestMethod.POST )
	public @ResponseBody void addChatRoom(@RequestBody UserAdmin userAdmin, HttpServletRequest servlet){
		System.out.println(userAdmin.toString());
		
		HttpSession sesion = servlet.getSession();
			
	}
}
