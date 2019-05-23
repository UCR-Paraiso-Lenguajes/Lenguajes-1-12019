package com.chat.domain;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.data.ChatRomData;

public class Rooms {
	
	@Autowired
	private ChatRomData roomData;
	@Autowired
	public List<ChatRoom> rooms;
	@Autowired
	private static Rooms roomsInstance = null;
	
	private Rooms() {
		rooms = Collections.synchronizedList(roomData.getRooms());
	}
	
	public static Rooms getInstance() {
		if(roomsInstance == null) {
			roomsInstance = new Rooms();
		}
		return roomsInstance;
	}
}
