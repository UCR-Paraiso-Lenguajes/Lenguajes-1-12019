package com.projectOne.interactiveMessaging.bussines;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.MessageData;
import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.User;

@Service
public class MessageBusiness {
	@Autowired
	private MessageData messageData;
	
	public ArrayList<Message> getMessagesByRange(int inicio, int fin, Iterator<User> userList, String nameMessageTableGroup, int idUserPage){
		ArrayList<Message> listMessagesWithType = 
		messageData.convertIteratorToArrayMessage(messageData.getMessagesByRange(inicio, fin, userList, nameMessageTableGroup));
		Message temp;
		for (int i = 0; i < listMessagesWithType.size(); i++) {
			temp = listMessagesWithType.get(i);
			if(temp.getUserTransmitter().getUser_id()==idUserPage) {
				listMessagesWithType.get(i).setType("sent");
			}else {
				listMessagesWithType.get(i).setType("replies");
			}
		}
		return listMessagesWithType;
	}
	
}
