package com.projectOne.interactiveMessaging.bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.MessageData;
import com.projectOne.interactiveMessaging.domain.ClassListNewMessages;
import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.SingleGroupMessage;
import com.projectOne.interactiveMessaging.domain.User;

@Service
public class MessageBusiness {
	@Autowired
	private MessageData messageData;
	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private GroupBusiness groupBusiness;
	public ArrayList<Message> getMessagesByRange(int inicio, int fin, Iterator<User> userList, String nameMessageTableGroup, int idUserPage){
		ArrayList<Message> listMessagesWithType = 
		messageData.convertIteratorToArrayMessage(messageData.getMessagesByRange(inicio, fin, userList, nameMessageTableGroup));
		Message temp;
		//Meter en una clase de utilidades
		for (int i = 0; i < listMessagesWithType.size(); i++) {
			temp = listMessagesWithType.get(i);
			if(temp.getUserTransmitter().getUser_id()==idUserPage) {
				listMessagesWithType.get(i).setType("sent");
			}else {
				listMessagesWithType.get(i).setType("replies");
			}
		}
		//
		return listMessagesWithType;
	}
	public void sendMessage(int idGroup, String text, int idUser) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		Timestamp temp = timestamp;
		temp.setHours(timestamp.getHours()-1);
		timestamp = temp;
		messageData.sendMessage(groupBusiness.getNameGroupTableMessages(idGroup), text, idUser, timestamp,text.length());
		//Primero Traer el usuario
		User userTransmitter = userBusiness.getSpecificUserById(idUser);
		//Segundo Construir el mensaje con
		//int message_id, String message, User userTransmitter, Timestamp dateMessage
		Message message = new Message(1,text,userTransmitter,timestamp);
		//Tercero construir SingleGroupMessage
		SingleGroupMessage singleGroupMessage = new SingleGroupMessage(idGroup,message);
		//Cuarto insertarlo
		ClassListNewMessages classList = new ClassListNewMessages();
		classList.storeNewMessage(singleGroupMessage);
	}
	
}
