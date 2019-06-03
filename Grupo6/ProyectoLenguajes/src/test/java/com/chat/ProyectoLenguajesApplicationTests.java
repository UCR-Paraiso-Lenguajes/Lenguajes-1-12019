package com.chat;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chat.data.ChatRoomData;
import com.chat.domain.ChatRoom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProyectoLenguajesApplicationTests {

	@Autowired
	private ChatRoomData roomData;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void rooms() {
		ArrayList<ChatRoom> rooms = roomData.getRooms();
		assertTrue(!rooms.isEmpty());
	}
}
