package cr.ac.ucr.business;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import cr.ac.ucr.domain.Message;
import cr.ac.ucr.domain.Room;
@Service
public class RoomBusiness {

	private Room room;
	
	public Iterator<Message> listMessages(){
		return room.getMessages();
	}

	
}
