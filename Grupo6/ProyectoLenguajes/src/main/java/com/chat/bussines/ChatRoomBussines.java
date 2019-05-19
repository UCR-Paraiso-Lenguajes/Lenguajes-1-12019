package com.chat.bussines;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.data.ChatRomData;
import com.chat.domain.ChatRoom;

public class ChatRoomBussines {
	
	@Autowired
	ChatRomData roomData;
	
	public void createRoom(ChatRoom room) {
		roomData.add(room);
	}
}
