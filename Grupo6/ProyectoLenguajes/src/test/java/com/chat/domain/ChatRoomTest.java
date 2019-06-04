package com.chat.domain;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chat.data.MetricDat;
import com.chat.exeption.chatException;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ChatRoomTest {

	@Test(expected = chatException.class)
	public void testChatRoomRoomWithException() {
		List<UserAdmin> users = new ArrayList<>();
		List<Message> messages = new ArrayList<>();
		Rol rol = new Rol(2, "nombre");

		UserAdmin userCreator = new UserAdmin(2, "xxx", "picachu", "valeria2@gmai.com", "Raul", rol);

		ChatRoom chatRoom = new ChatRoom(2, "", 2, "/localhost:8585", users, messages, userCreator);

	}
	
	
	

}
