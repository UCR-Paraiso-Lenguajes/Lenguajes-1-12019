package com.chat.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.UserBussines;
import com.chat.data.UserData;
import com.chat.domain.Rol;
import com.chat.domain.UserClient;

@RestController
public class LoginUserControllerRest {
	
	@Autowired
	UserBussines userBussines;
	
	@Autowired
	UserData userData;

	@RequestMapping(value="api/LoginUser", method=RequestMethod.POST )
	public @ResponseBody void addChatRoom(@RequestBody UserClient userClient , HttpServletRequest servlet){
		int idUserClient = 0;
		String idUser="user";
		HttpSession sesion = servlet.getSession();
		
		if(userBussines.createUserValidation(userClient) == true) {
			
			idUserClient =	userData.addUserClient(userClient);
		}
		
		Rol rolDomain = new Rol(1,"Client");
		
		userClient.setId(idUserClient);
		userClient.setRol(rolDomain);
			
		System.out.println(userClient.toString());
		sesion.setAttribute(idUser, userClient);
		
	}
		
}
