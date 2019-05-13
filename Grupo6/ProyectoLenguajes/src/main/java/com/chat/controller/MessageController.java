package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chat.bussines.MessageBussines;

@Controller
public class MessageController {
	
	@Autowired
	MessageBussines messageBussines;
	
}
