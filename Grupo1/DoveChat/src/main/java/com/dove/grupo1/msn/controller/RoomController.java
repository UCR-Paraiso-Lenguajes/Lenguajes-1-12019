package com.dove.grupo1.msn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RoomController {

	@RequestMapping(value="/user/msn", method=RequestMethod.GET)
	public String userLogin(){
		return "login";
	}
}
