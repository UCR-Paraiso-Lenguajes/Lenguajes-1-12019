package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTest {

	@Autowired
	private UserData userData;
	
	@Test
	public void findUsersTest() {
		Iterator<User>userList = userData.findUsersCertainRoom(2);
		assertNotNull(userList);
	}
}
