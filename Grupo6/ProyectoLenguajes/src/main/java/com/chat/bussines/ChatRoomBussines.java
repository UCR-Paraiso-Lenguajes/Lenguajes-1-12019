package com.chat.bussines;

import java.util.ArrayList;
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
		//Rooms rooms = new Rooms();
		ArrayList<ChatRoom> rooms = chatRomData.getRooms();
		for (ChatRoom chatRoom : rooms) {
			Random r = new Random();
			int min = 0;
			int max = 49;
			int valueAvatar = r.nextInt((max - min) + 1) + min;
			String avatar = "\\src\\main\\resources\\img\\img" + valueAvatar;
			chatRoom.setAvatar(avatar);
		}
		return rooms.iterator();
	}	
}
