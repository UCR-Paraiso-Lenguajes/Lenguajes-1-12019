package com.chat.bussines;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chat.data.ChatRoomData;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;
import com.chat.domain.Rol;
import com.chat.domain.UserAdmin;
import com.chat.domain.UserClient;
import com.chat.exeption.chatException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatRoomBussinesTest {
	@Autowired
	ChatRoomBussines chatRoomBussines;
	@Autowired
	ChatRoomData chatRomData;

	@Test(expected = chatException.class)
	public void testChatRoomBussinesWithException() {

		List<UserAdmin> users = new ArrayList<>();
		List<Message> messages = new ArrayList<>();
		Rol rol = new Rol(2, "nombre");

		UserAdmin userCreator = new UserAdmin(2, "xxx", "picachu", "valeria2@gmai.com", "Raul", rol);

		ChatRoom chatRoom = new ChatRoom(2, "test", 2, "/localhost:8585", users, messages, userCreator);

		chatRoomBussines.addRom(chatRoom); 

	} 

	@Test
	public void testChatRoomBussinesWithObjectUserAdmin() {
		ArrayList<ChatRoom> rooms = chatRomData.getRooms();
		assertTrue(rooms.get(1).getUser_creator() instanceof UserAdmin );

	}
	
	@Test
	public void testChatRoomBussinesWithObjectUserClient() {
		ArrayList<ChatRoom> rooms = chatRomData.getRooms();
		
		assertTrue(rooms.get(3).getListUsers().get(1)  instanceof UserClient );

	}

	@Test(expected = chatException.class)
	public void testChatRoomBussinesWithExceptionMaximoMaxUsers() {

		chatRoomBussines.getRoomsByGuess("25", 5);

	}
	
	@Test(expected = chatException.class)
	public void testChatRoomBussinesWithCreate() {

		List<UserAdmin> users = new ArrayList<>();
		List<Message> messages = new ArrayList<>();
		Rol rol = new Rol(2, "nombre");

		UserAdmin userCreator = new UserAdmin();

		ChatRoom chatRoom = new ChatRoom(2, "Redes", 2, "/localhost:8585", users, messages, userCreator);

		chatRoomBussines.addRom(chatRoom); 

	}
}
