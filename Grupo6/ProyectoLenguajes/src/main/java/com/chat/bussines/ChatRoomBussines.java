package com.chat.bussines;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.data.ChatRomData;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;

public class ChatRoomBussines {
	
	@Autowired
	ChatRomData roomData;
	
	public void createRoom(ChatRoom room) {
		roomData.add(room);
	}
	
	public ConcurrentHashMap<Integer, Message> loadMessages (int begin, int end, ChatRoom room){
		ConcurrentHashMap<Integer, Message> messages = null;
		if(room.getMessages().isEmpty()) {
			messages = roomData.getMessages(begin, end, room);
		}else {
			messages = room.getMessages();
		}
		return messages;
	}
}
