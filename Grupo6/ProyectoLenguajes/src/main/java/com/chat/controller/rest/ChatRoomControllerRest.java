package com.chat.controller.rest;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.ChatRoomBussines;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;

@RestController
public class ChatRoomControllerRest {
	
	@Autowired
	private ChatRoomBussines chatRoomBussines;
	
	@RequestMapping(value="api/ChatRoom", method=RequestMethod.POST )
	public @ResponseBody void addChatRoom(@RequestBody ChatRoom chatRoom, HttpServletRequest servlet){
		System.out.println(chatRoom.toString());
		
		HttpSession sesion = servlet.getSession();	
		chatRoomBussines.addRom(chatRoom);		
	}
	
	@RequestMapping(value="api/ChatRoom", method=RequestMethod.GET )
	public @ResponseBody Iterator<Message> loadMessages(@RequestBody ChatRoom chatRoom, HttpServletRequest servlet){
		HttpSession sesion = servlet.getSession();
		return chatRoomBussines.loadMessages(chatRoom);
	}
}
