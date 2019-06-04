package com.projectOne.interactiveMessaging.domain;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassListNewMessagesTest {
	@Test
	public void sendTest() {
		
	}
	@Test
	public void getTest() {
		ClassListNewMessages cl = new ClassListNewMessages();
		ClassListNewMessages c2 = new ClassListNewMessages();
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		Timestamp temp = timestamp;
		temp.setHours(timestamp.getHours()-1);
		timestamp = temp;
		Message m1 = new Message(0,"HOLA 1",new User(1, "lllllllll", 1),timestamp);
		cl.storeNewMessage(new SingleGroupMessage(2,m1));
		
		
		ArrayList<SingleGroupMessage> sg = c2.extractLastMessages(2,1);
		assertNotNull(sg);
	}
}
