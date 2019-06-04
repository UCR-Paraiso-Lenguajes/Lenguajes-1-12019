package com.projectOne.interactiveMessaging.bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectOne.interactiveMessaging.data.MessageData;
import com.projectOne.interactiveMessaging.domain.ClassListNewMessages;
import com.projectOne.interactiveMessaging.domain.GroupUser;
import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.SingleGroupMessage;
import com.projectOne.interactiveMessaging.domain.TableMessagesGroups;
import com.projectOne.interactiveMessaging.domain.User;

@Service
public class MessageBusiness {
	@Autowired
	private MessageData messageData;
	@Autowired
	private UserBusiness userBusiness;
	@Autowired
	private GroupBusiness groupBusiness;
	
	private TableMessagesGroups tableGroups = new TableMessagesGroups();
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
		
		//Insertar el grupo a la tabla si no existe y si ya existe agregar ese idUser a la lista
		
		
		if(tableGroups.existUserFromAnyGroup(idUser)) {
			tableGroups.deleteUserFromAnyGroup(idUser);
			tableGroups.changeGroup(idGroup,idUser, true);
		}else {
			if(tableGroups.existGroup(idGroup)) {
				tableGroups.changeGroup(idGroup,idUser, true); 
			}else {
				tableGroups.storeNewGroup(new GroupUser(idGroup));
				tableGroups.changeGroup(idGroup,idUser, true); 
			}
			
		}
		boolean existGroup = tableGroups.existGroup(idGroup);
		boolean existUser = tableGroups.existUserOnGroup(idGroup, idUser);
		boolean existUserOfAnyGroup = tableGroups.existUserFromAnyGroup(idUser);
		//Cuarto insertarlo
		ClassListNewMessages classList = new ClassListNewMessages();
		singleGroupMessage.setUsersIDs(tableGroups.getGroup(idGroup).getIds());
		classList.storeNewMessage(singleGroupMessage);
	}
	public void addUserGroupRT(int idGroup, int idUser) {
		if(tableGroups.existUserFromAnyGroup(idUser)) {
			tableGroups.deleteUserFromAnyGroup(idUser);
			tableGroups.changeGroup(idGroup,idUser, true);
		}else {
			if(tableGroups.existGroup(idGroup)) {
				tableGroups.changeGroup(idGroup,idUser, true); 
			}else {
				tableGroups.storeNewGroup(new GroupUser(idGroup));
				tableGroups.changeGroup(idGroup,idUser, true); 
			}
			
		}
	}
	
}

