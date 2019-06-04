package com.projectOne.interactiveMessaging.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.bussines.MetricsBusiness;
import com.projectOne.interactiveMessaging.data.MetricsData;
import com.projectOne.interactiveMessaging.domain.Metrics;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsBussinessTest {
	@Autowired
	private MetricsData metricsData;
	@Autowired
	private MetricsBusiness metricsBusiness;
	Metrics metrics = Metrics.getInstance();
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
		metrics = metricsData.findMetrics(1);
		System.out.println(metrics.toString());
	}
	
	@Test
	public void updateMessageMetrics_LongestMessage_Test() {
		metricsBusiness.updateMessageMetrics("111");
		String messages = metrics.getLongestMessage();
		assertEquals("111",messages);
	}
	
	@Test
	public void updateDateLastMessage_Test() {
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2019-09-23 10:10:10.0");		
		metricsBusiness.updateDateLastMessage(timestamp);
		Timestamp date = metrics.getDateLastMessage();
		assertEquals(timestamp,date);
	}
	
	@Test
	public void updateNumbersOfRooms_Test() {
		metricsBusiness.updateNumbersOfRooms();
		int counterGroups = metrics.getNumberOfRooms();
		assertEquals(10,counterGroups);
	}
	
	@Test
	public void updateNumbersOfUsers_Test() {
		metricsBusiness.updateNumbersOfUsers();
		int counterUsers = metrics.getNumberOfUsers();
		assertEquals(7,counterUsers);
	}
	
	@Test
	public void updateAverageOfUsersPerRoom_Test() {
		metricsBusiness.updateAverageOfUsersPerRoom(3);
		float average = metrics.getAverageOfUsersPerRoom();
		assertEquals(3.4,average,0.5);
	}
	
	
	@Test
	public void updateDateFirstLogin_Test() {
		metricsBusiness.updateDateFirstLogin();
		Timestamp date = metrics.getDateFirstLogin();
		assertEquals("2019-05-10 22:59:53.0",date+"");
	}
	
	@Test
	public void updateLastGroupCreate_Test() {
		metricsBusiness.updateLastGroupCreate();
		String name_Group = metrics.getLastRoomCreated();
		assertEquals("Elios",name_Group);
	}

}
