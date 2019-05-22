package com.dove.grupo1.msn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {

	/**
	 * Muestra la vista del login de usuario 
	 * @return
	 */
	@RequestMapping(value="/user/msn", method=RequestMethod.GET)
	public String userLogin(){
		return "loginUser";
	}
}
