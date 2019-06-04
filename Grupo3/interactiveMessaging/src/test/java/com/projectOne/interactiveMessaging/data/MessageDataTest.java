package com.projectOne.interactiveMessaging.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.timeout;

import java.util.Date;
import java.util.Iterator;
import java.sql.Time;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDataTest {

	@Autowired
	private MessageData messageData;
	@Autowired
	private UserData userData;
	
	private Iterator<Message>messages;
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
		messages = messageData.getMessagesByRange(1, 999999, userData.findUsersCertainRoom(2),"LosMagnificosMessages");
    }
	
	@Test
	public void getMessagesByRange_isEquals_Test() {
		
		assertSame(messages, messages);
	}
	
	@Test
	public void getMessagesByRange_NotNull_Test() {
		assertNotNull(messages);
	}
	
	@Test
	public void getMessagesByRange_isEmpty_Test() {
		assertTrue(messages.hasNext());
	}
	
	@Test
	public void getMessagesByRange_CorrectResultId_Test() {
		int id = messages.next().getMessage_id();
		assertEquals(1, id);
	}
	
	@Test
	public void getMessagesByRange_CorrectResultTimesTamp_Test() {
		Timestamp date = messages.next().getDateMessage();
		assertEquals("2019-05-11 20:56:37.0", date+"");
	}
	
	@Test
	public void getMessagesByRange_CorrectResultMessage_Test() {
		String message = messages.next().getMessage();
		assertEquals("Como estan perros?", message);
	}
	
	@Test
	public void getMessagesByRange_CorrectResultType_Test() {
		String type = messages.next().getType();
		assertNull("Valor type Null", type);
	}
	
	@Test
	public void getMessagesByRange_CorrectResultUserNotNull_Test() {
		User user = messages.next().getUserTransmitter();
		assertNotNull("Valor user NotNull", user);
	}
	
	@Test
	public void getMessagesByRange_CorrectResultUserId_Test() {
		User user = messages.next().getUserTransmitter();
		assertEquals(1, user.getUser_id());
	}
	
	@Test
	public void getMessagesByRange_CorrectResultUserEmail_Test() {
		User user = messages.next().getUserTransmitter();
		assertEquals("manfredgh@hotmail.com", user.getUser_email());
	}
	
	@Test
	public void getMessagesByRange_CorrectResultUserNameRole1_Test() {
		User user = messages.next().getUserTransmitter();
		String nameRole= user.getRoles().get(1).getName_Role();
		assertEquals("Owner", nameRole);
	}
	
	@Test
	public void getMessagesByRange_CorrectResultUserNameRole0_Test() {
		User user = messages.next().getUserTransmitter();
		String namerole0 = user.getRoles().get(0).getName_Role();
		assertEquals("Admin", namerole0);
	}
	
//	@Test
//	public void sendMessageTest() {
//		String text = "Envio message por Test";
//		
//		Date date = new Date();
//		Timestamp timestamp = new Timestamp(date.getTime());
//		Timestamp temp = timestamp;
//		temp.setHours(timestamp.getHours()-1);
//		timestamp = temp;
//		
//		messageData.sendMessage("LosMagnificosMessages", text, 2,timestamp, text.length());
//	}
}