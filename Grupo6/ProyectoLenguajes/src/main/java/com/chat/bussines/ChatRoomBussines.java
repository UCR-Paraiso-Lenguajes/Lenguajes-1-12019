package com.chat.bussines;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.ChatRomData;
import com.chat.domain.ChatRoom;
import com.chat.domain.Rooms;


@Service
public class ChatRoomBussines {

	@Autowired 
	private ChatRomData chatRomData;

	public void addRom(ChatRoom chatRoom) {
		chatRomData.add(chatRoom);
	}
	
	
	public Iterator<ChatRoom> getRooms(){
		Rooms rooms = Rooms.getInstance();
		return rooms.getRooms();
	}
	
}
