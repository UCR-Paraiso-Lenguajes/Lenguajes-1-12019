package com.chat.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.chat.data.MessageData;
import com.chat.domain.Message;

@Service
public class MessageBussines {
	
	//@Autowired
	//MessageData messageData;
	
	public void save(Message message) {
		//messageData.save(message);
	}
}
