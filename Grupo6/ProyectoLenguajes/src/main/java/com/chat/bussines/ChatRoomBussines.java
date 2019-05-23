package com.chat.bussines;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.data.ChatRomData;
import com.chat.domain.ChatRoom;


@Service
public class ChatRoomBussines {

	@Autowired
	private ChatRomData chatRomData;

	public void addRom(ChatRoom chatRoom) {

		Random r = new Random();
		int min = 0;
		int max = 49;
		int valueAvatar = r.nextInt((max - min) + 1) + min;
		String avatar = "img" + valueAvatar;
		
		
		chatRomData.add(chatRoom);
		

	}
	
}
