package com.videcartago.renting.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videcartago.renting.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTest {
	@Autowired
	private UserData userData;

	@Test
	public void finUser() 
	{
		User user = userData.findByEmail("admin@gmail.com");
		assertNotNull(user);
		assertEquals("Admin", user.getName());
		
	}
	
	@Test
	public void NoUser() 
	{
		User user = userData.findByEmail("admin");
		assertNull(user);
		
	}
}


