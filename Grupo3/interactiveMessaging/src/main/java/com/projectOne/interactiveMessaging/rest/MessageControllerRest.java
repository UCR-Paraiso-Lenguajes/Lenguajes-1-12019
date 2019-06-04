package com.projectOne.interactiveMessaging.rest;


import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectOne.interactiveMessaging.bussines.GroupBusiness;
import com.projectOne.interactiveMessaging.bussines.MessageBusiness;
import com.projectOne.interactiveMessaging.data.GroupData;
import com.projectOne.interactiveMessaging.data.UserData;
import com.projectOne.interactiveMessaging.domain.ClassListNewMessages;
import com.projectOne.interactiveMessaging.domain.Message;
import com.projectOne.interactiveMessaging.domain.MessageToSend;
import com.projectOne.interactiveMessaging.domain.SingleGroupMessage;
import com.projectOne.interactiveMessaging.domain.TableMessagesGroups;

@RestController
public class MessageControllerRest {
	@Autowired
	private MessageBusiness messageBusiness;
	@Autowired
	private UserData userData;
	@Autowired
	private GroupBusiness groupBusiness;
	@RequestMapping(value="/api/messages", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Message> listMessages(@RequestParam(value="idGroup") int idGroup,
			@RequestParam(value="idUserRoom") int idUserRoom){
		
		
		ArrayList<Message> messages=

				messageBusiness.getMessagesByRange(1, 999999, userData.findUsersCertainRoom(idGroup),groupBusiness.getNameGroupTableMessages(idGroup),idUserRoom);
		return messages;
	}
	@RequestMapping(value="/api/sendMessages/{idGroup}/{idUserRoom}", method=RequestMethod.PUT)
	public @ResponseBody void sendMessage(@PathVariable int idGroup,
			@PathVariable int idUserRoom,
			@RequestBody MessageToSend message){
		
		messageBusiness.sendMessage(idGroup, message.getMessage(), idUserRoom);
	}
	@RequestMapping(value="/api/usersGroup/{idGroup}/{idUserRoom}", method=RequestMethod.POST)
	public @ResponseBody void addUserGroup(@PathVariable int idGroup,
			@PathVariable int idUserRoom){
		
		messageBusiness.addUserGroupRT(idGroup,idUserRoom);
	}
	@RequestMapping(value="/api/newmessages", method=RequestMethod.GET)
	public @ResponseBody ArrayList<SingleGroupMessage> getNewMessages(@RequestParam(value="idGroup") int idGroup,
			@RequestParam(value="idUserRoom") int idUserRoom){
		ClassListNewMessages classListRest = new ClassListNewMessages();
		ArrayList<SingleGroupMessage> messages = classListRest.extractLastMessages(idGroup,idUserRoom);
		ArrayList<SingleGroupMessage> messagesOthers = new ArrayList<>();
		TableMessagesGroups tableGroups = new TableMessagesGroups();
		boolean existGroup = tableGroups.existGroup(idGroup);
		for (int i = 0; i < messages.size(); i++) {
			if(messages.get(i).getMessage().getUserTransmitter().getUser_id()==idUserRoom) {
				messages.get(i).getMessage().setType("sent");
			}else {
				messages.get(i).getMessage().setType("replies");
				messagesOthers.add(messages.get(i));
			}
		}
		
		return messagesOthers;
	}
	
}
