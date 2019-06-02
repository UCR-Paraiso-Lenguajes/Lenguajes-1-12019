package com.chat.bussines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.ChatRomData;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;
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
			String avatar = "~/chat/src/main/resources/templates/img/img" + valueAvatar;
			chatRoom.setAvatar(avatar);
			chatRoom.setListMessage(chatRomData.getMessages(-1, 50, chatRoom));
			System.out.println(chatRoom.toString());
		}
		return rooms.iterator();
	}
	
	public Iterator<Message> loadMessages(ChatRoom room){
		return chatRomData.getMessages(0, 50, room).iterator();
	}
}
