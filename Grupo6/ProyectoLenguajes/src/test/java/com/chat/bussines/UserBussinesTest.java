package com.chat.bussines;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chat.data.ChatRoomData;
import com.chat.data.UserData;
import com.chat.domain.ChatRoom;
import com.chat.domain.Message;
import com.chat.domain.Rol;
import com.chat.domain.UserAdmin;
import com.chat.domain.UserClient;
import com.chat.exeption.chatException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBussinesTest {
	@Autowired
	UserBussines userBussines;
	@Autowired
	UserData userdata;

	@Test
	public void testUserBussinessEmail() {

		Rol rol = new Rol(2, "nombre");

		UserClient user = new UserClient(3, "xxx", "valerialeivaquiros@gmail.com", "Valeria", rol);

		assertTrue(userBussines.sendEmail(user, 1));

	}

	@Test
	public void testUserBussinesUserfakeAnd() {

		Rol rol = new Rol(2, "nombre");

		UserClient user = new UserClient(3, "xxx", "valerialeivaquiros@gmail.com", "Valeria", rol);

		assertFalse(userBussines.SetParametters(user).getAvatar() == null);
		assertNotNull(userBussines.SetParametters(user));

	}

	
	@Test(expected = chatException.class)
	public void testUserBussinessEmailParam() {

		UserClient user = null;
		assertTrue(userBussines.sendEmail(user, 1));
		assertNull(userBussines.SetParametters(user));

	}
}
