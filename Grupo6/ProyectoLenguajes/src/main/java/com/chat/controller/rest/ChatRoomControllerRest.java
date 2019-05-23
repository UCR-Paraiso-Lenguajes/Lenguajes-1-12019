package com.chat.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.bussines.ChatRoomBussines;
import com.chat.domain.ChatRoom;

@RestController
public class ChatRoomControllerRest {
	@Autowired
	private ChatRoomBussines chatRoomBussines;
	
	
	@RequestMapping(value="api/ChatRoom", method=RequestMethod.POST )
	public @ResponseBody void addChatRoom(@RequestBody ChatRoom chatRoom)
	{
		System.out.println(chatRoom.toString());
		chatRoomBussines.addRom(chatRoom);
		
		
	}
}
