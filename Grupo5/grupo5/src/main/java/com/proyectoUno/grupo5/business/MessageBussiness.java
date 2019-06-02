package com.proyectoUno.grupo5.business;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.dao.MessageDao;
import com.proyectoUno.grupo5.domain.Message;

@Service
public class MessageBussiness {
		
	    @Autowired
	    private MessageDao messageDao;
	    
	    public Boolean insertMessage(Message message) throws SQLException {
	        return messageDao.insertMessage(message);
	    }
	    
	    public List<Message> getMessagesByIdRoom(int idRoom){
	    	
	    	return messageDao.getMessagesByIdRoom(idRoom);
	    }
	    
	    public Map<Integer, Message> insertMessageSincro(Message message){

	    	return messageDao.insertMessageSincro(message);
	    	
	    	
	    }

}
