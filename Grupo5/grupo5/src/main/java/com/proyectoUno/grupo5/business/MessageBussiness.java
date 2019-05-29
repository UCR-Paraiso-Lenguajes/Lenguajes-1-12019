package com.proyectoUno.grupo5.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoUno.grupo5.dao.MessageDao;
import com.proyectoUno.grupo5.dao.RoomDao;
import com.proyectoUno.grupo5.domain.Room;
@Service
public class MessageBussiness {
	
	
	
	
	    @Autowired
	    private MessageDao messageDao;

	    
	    public Boolean createTableMessage(String tableNameMessage) throws SQLException {
	        return messageDao.createTableMessage(tableNameMessage);
	    }

}
