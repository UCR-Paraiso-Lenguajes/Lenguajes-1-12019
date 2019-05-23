package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.timeout;

import java.util.Iterator;
import java.sql.Time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDataTest {

	@Autowired
	private MessageData messageData;
	@Autowired
	private UserData userData;
	
	@Test
	public void getMessagesByRangeTest() {
		Iterator<Message>messages = messageData.getMessagesByRange(1, 999999, userData.findUsersCertainRoom(2),"LosMagnificosMessages");
		
		assertNotNull(messages);
	}
}
