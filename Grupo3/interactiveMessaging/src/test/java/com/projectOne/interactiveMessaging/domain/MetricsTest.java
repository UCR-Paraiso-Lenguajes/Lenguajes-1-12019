package com.projectOne.interactiveMessaging.domain;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.data.GroupData;
import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.data.UserData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsTest {
	
	@Autowired
	private MetricsData metricsData;
	@Autowired
	private GroupData groupData;
	@Autowired
	private UserData userData;
	
	Metrics metrics = Metrics.getInstance();
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
		metrics = metricsData.findMetrics(1);
		System.out.println(metrics.toString());
	}
	
	@Test
	public void updateMessageMetrics_LongestMessage_Test() {
		metrics.updateMessageMetrics("111");
		String messages = metrics.getLongestMessage();
		assertEquals("111",messages);
	}
	
	@Test
	public void updateDateLastMessage_Test() {
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2019-09-23 10:10:10.0");		
		metrics.updateDateLastMessage(timestamp);
		Timestamp date = metrics.getDateLastMessage();
		assertEquals(timestamp,date);
	}
	
	@Test
	public void updateNumbersOfRooms_Test() {
		Iterator<Room> rooms = groupData.getGroups();
		metrics.updateNumbersOfRooms(rooms);
		int counterGroups = metrics.getNumberOfRooms();
		assertEquals(15,counterGroups);
	}
	
	@Test
	public void updateNumbersOfUsers_Test() {
		Iterator<User> users= userData.findAllTheUsers();
		metrics.updateNumbersOfUsers(users);
		int counterUsers = metrics.getNumberOfUsers();
		assertEquals(7,counterUsers);
	}
	
	@Test
	public void updateAverageOfUsersPerRoom_Test() {
		metrics.setSumOfUsersPerGroup(30);
		metrics.setNumberOfRooms(15);
		metrics.updateAverageOfUsersPerRoom();
		float average = metrics.getAverageOfUsersPerRoom();
		assertEquals(2.2,average,0.5);
	}
	
	
	@Test
	public void updateDateFirstLogin_Test() {
		Iterator<Room> rooms = groupData.getGroups();
//		metrics.updateDateFirstLogin(rooms);
		Timestamp date = metrics.getDateFirstLogin();
		assertEquals("2019-05-10 22:59:53.0",date+"");
	}
	
	@Test
	public void updateLastGroupCreate_Test() {
//		Iterator<Room> rooms = groupData.getGroups();
//		metrics.updateLastGroupCreate(rooms);
//		String name_Group = metrics.getLastRoomCreated();
//		assertEquals("Mountain",name_Group);
	}

}
