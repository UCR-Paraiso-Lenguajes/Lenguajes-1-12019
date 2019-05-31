package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDataTest {
	@Autowired
	private GroupData groupData;
	
	@Test
	public void getNameGroupTableMessagesTest() {
		String nameTable = groupData.getNameGroupTableMessages(2);
		assertNotNull(nameTable);
	}
	@Test
	public void getSpecificGroupTest() {
		Room room = groupData.getSpecificGroup(2);
		assertNotNull(room);
	}
	@Test
	public void getGroupsOfUserTest() {
		List<Room> room = groupData.getGroupsOfUser(1);
		assertNotNull(room);
	}
}
