package com.chat.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.ChatRoomBussines;
import com.chat.bussines.UserBussines;
import com.chat.domain.ChatRoom;
import com.chat.domain.UserAdmin;
import com.chat.domain.UserClient;
import com.ram.configuration.AppConfig;
import com.ram.service.MailService;
import com.ram.service.MailServiceImpl;

@RestController
public class UserControllerRest {
	@Autowired
	private UserBussines userBussines;

	@RequestMapping(value = "api/User", method = RequestMethod.POST)
	public @ResponseBody void addChatRoom(@RequestBody UserClient user) {
		userBussines.sendEmail(user);

	}
}
