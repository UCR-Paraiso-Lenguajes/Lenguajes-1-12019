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
	
	
	
	@RequestMapping(value="/user/msn/userChatRoom", method=RequestMethod.GET)
	public String userRoom(){
		return "UserChatRoom";
	}
	
	
	@RequestMapping(value="/user/msn/adminMenu", method=RequestMethod.GET)
	public String adminRoom(){
		return "AdminMenu";
	}
	
	
	@RequestMapping(value="/user/msn/adminManagementRoom", method=RequestMethod.GET)
	public String adminManagementRoom(){
		return "AdminManagementRoom";
	}
	
	@RequestMapping(value="/user/msn/newRoom", method=RequestMethod.GET)
	public String newRoom(){
		return "NewRoom";
	}
	
	@RequestMapping(value="/user/msn/addUser", method=RequestMethod.GET)
	public String addUser(){
		return "AddUser";
	}
	
	@RequestMapping(value="/user/msn/roomInfo", method=RequestMethod.GET)
	public String roomInfo(){
		return "RoomInfo";
	}
}
