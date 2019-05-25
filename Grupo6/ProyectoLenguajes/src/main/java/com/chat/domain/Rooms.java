package com.chat.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.data.ChatRomData;

public class Rooms {
	
	@Autowired
	private ChatRomData roomData;
	@Autowired
	private ArrayList<ChatRoom> rooms;

	private static Rooms roomsInstance = null;
	
	private Rooms() {
		rooms = (ArrayList<ChatRoom>) Collections.synchronizedList(roomData.getRooms());
	}
	
	public static Rooms getInstance() {
		if(roomsInstance == null) {
			roomsInstance = new Rooms();
		}
		return roomsInstance;
	}
	
	public Iterator<ChatRoom> getRooms(){
		
		ArrayList<ChatRoom> listRooms = rooms;
		
		for (ChatRoom chatRoom : listRooms) {
			Random r = new Random();
			int min = 0;
			int max = 49;
			int valueAvatar = r.nextInt((max - min) + 1) + min;
			String avatar = "img" + valueAvatar;
			chatRoom.setAvatar(avatar);
		}
		return rooms.iterator();
	}
}
