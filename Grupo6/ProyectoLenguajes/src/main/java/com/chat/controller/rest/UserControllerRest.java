package com.chat.controller.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.ChatRoomBussines;
import com.chat.bussines.UserBussines;
import com.chat.data.UserData;
import com.chat.domain.ChatRoom;
import com.chat.domain.UserAdmin;
import com.chat.domain.UserClient;


@RestController
public class UserControllerRest {
	@Autowired
	private UserBussines userBussines;
	@Autowired 
	private UserData userdata;

	@RequestMapping(value = "api/User/{room}", method = RequestMethod.POST)
	public @ResponseBody void addChatRoom(@RequestBody UserClient user, @PathVariable int room) {
		userBussines.sendEmail(user, room);
		
		
		
	}
}
