package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.Metrics;
import com.projectOne.interactiveMessaging.domain.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsDataTest {
	
	@Autowired
	private MetricsData metricsData;
//	Metrics metrics = Metrics.getInstance();
//	Iterator<Metrics> metrics;
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
//		metrics = metricsData.findMetrics(1);
	}
	
//	@Test
//	public void saveMetrics() {
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
//		try {
//			java.util.Date date = dateformat.parse("2019/04/10");
//			java.util.Date date2 =  dateformat.parse("2019/03/14");
//			assertTrue(metricsData.saveMetrics(5, 20, 30, 10, date, date2, 12, 100, 22, 9, 100, 400));
//			//metricsData.saveMetrics(3, 20, 30, 10, date, date2, 12, 100, 22, 9, 100, 400);
//		} catch (ParseException e) {
//			throw new RuntimeException("Error al declarar fecha");
//		}
//		
//	}
	
	
//	
//	@Test
//	public void findMetrics_NotNull_Test() {
//		assertNotNull(metrics);
//	}
//	
////	@Test
////	public void findMetrics_IsEmpty_Test() {
////		assertTrue(metrics.hasNext());
////	}
//	
//	@Test
//	public void findMetrics_ObjectCorrect_Test() {
//		assertSame(metrics, metrics);
//	}
//	
//	@Test
//	public void findMetrics_forId_Test() {
//		int id= metrics.getId_Metrics();
//		assertEquals(1, id);
//	}
//	
//	@Test
//	public void findMetrics_numbersUsers_Test() {
//		int numbersUsers= metrics.getNumberOfUsers();
//		assertEquals(30, numbersUsers);
//	}
//	
//	@Test
//	public void findMetrics_getNumberOfRooms_Test() {
//		int numbersRooms= metrics.getNumberOfRooms();
//		assertEquals(5, numbersRooms);
//	}
//	
//	@Test
//	public void findMetrics_getAverageOfUsersPerRoom_Test() {
//		float average= metrics.getAverageOfUsersPerRoom();
//		assertEquals(1.2, average,0.0002);
//	}
//	
//	@Test
//	public void findMetrics_getDateLastMessage_Test() {
//		Timestamp date= metrics.getDateLastMessage();
//		assertEquals("2019-05-14", date+"");
//	}
//	
//	@Test
//	public void findMetrics_getDateFirstLogin_Test() {
//		Timestamp date=  metrics.getDateFirstLogin();
//		assertEquals("2019-05-19", date+"");
//	}
//	
//	@Test
//	public void findMetrics_getIdBigUser_Test() {
//		String BigerUser= metrics.getBigUser();
//		assertEquals("21", BigerUser);
//	}
//	
//	@Test
//	public void findMetrics_getNumberMessagesBigUser_Test() {
//		int numberMessageBIgUser= metrics.getNumberMessagesBigUser();
//		assertEquals(200, numberMessageBIgUser);
//	}
//	
//	@Test
//	public void findMetrics_getIdLongestMessage_Test() {
//		String LongestMessage= metrics.getLongestMessage();
//		assertEquals("12", LongestMessage);
//	}
//	
//	@Test
//	public void findMetrics_getIdLastRoomCreated_Test() {
//		String LastRoomCreated= metrics.getLastRoomCreated();
//		assertEquals("22", LastRoomCreated);
//	}

}