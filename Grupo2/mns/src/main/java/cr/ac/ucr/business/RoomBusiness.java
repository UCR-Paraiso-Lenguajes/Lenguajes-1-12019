package cr.ac.ucr.business;

import java.util.ArrayList;
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

	
	public Iterator<Message> processMessage(Message message){
		
		
		room.process(message);
		return room.getMessages();
		
	}
	
	
	public ArrayList<Room> staticRooms = new ArrayList<Room>();

	public void addRoom(Room room) {
		
		staticRooms.add(room);
		
	}
	
	
	
	
	
}
