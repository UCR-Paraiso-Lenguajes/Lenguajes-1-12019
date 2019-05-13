package cr.ac.ucr.business;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.data.MessageData;
import cr.ac.ucr.domain.Message;
import cr.ac.ucr.exceptions.ProjectExceptions;

@Service
public class MessageBusiness {
	@Autowired
	private MessageData messageData;
	
	public List<Message> listMessages(int amount){
		if(amount >= 0) {
			return messageData.ListMessages(amount);
		}
		throw new ProjectExceptions("La cantidad de mensajes no puede ser negativa.");
	}


    public void insertMessage(Message message) throws SQLException {
		if(message == null ) throw new ProjectExceptions("El mensaje es requerida");
		if(message.getContent().length() > 500 ) throw new ProjectExceptions("El mensaje no puede tener mas de 500 caracteres");
		messageData.insertMessage(message);
	}


}
