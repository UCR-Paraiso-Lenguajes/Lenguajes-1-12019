package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

import org.junit.Before;
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
	
	Iterator<User>userList;
	Iterator<Integer>idGroupsOfUsr;
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
		userList = userData.findUsersCertainRoom(2);
		idGroupsOfUsr = userData.getIdGroupsOfUsr(1);
	}
	
	@Test
	public void findUsers_NotNull_Test() {
		assertNotNull(userList);
	}
	
	@Test
	public void findUsers_ObjectCorrect_Test() {
		assertSame(userList,userList);
	}
	
	@Test
	public void findUsers_isEmpty_Test() {
		assertTrue(userList.hasNext());
	}
	
	@Test
	public void findUsers_idUser_Test() {
		int id = userList.next().getUser_id();
		assertEquals(1, id);
	}
	
	@Test
	public void findUsers_UserEmail_Test() {
		String email = userList.next().getUser_email();
		assertEquals("manfredgh@hotmail.com", email);
	}
	
	@Test
	public void findUsers_rolOne_Test() {
		String role = userList.next().getRoles().get(1).getName_Role();
		assertEquals("Owner", role);
	}
	
	@Test
	public void findUsers_rolTwo_Test() {
		String namerole0 = userList.next().getRoles().get(0).getName_Role();
		assertEquals("Admin", namerole0);
	}
	
	@Test
	public void getIdGroupsOfUsrTest() {
		assertNotNull(idGroupsOfUsr);
	}
	
	@Test 
	public void getIdInvite() {
		int id_user = userData.save("emmanuelsolano33@gmail.com");
		
		assertEquals(4, id_user);
	}
	
	@Test
	public void getSpecificUserById() {
		User user = userData.getSpecificUserById(1);
		assertNotNull(user);
	}
	
	
}
