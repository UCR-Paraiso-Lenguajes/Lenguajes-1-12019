package cr.ac.ucr.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.data.RoomData;
import cr.ac.ucr.domain.Message;
import cr.ac.ucr.domain.Room;
@Service
public class RoomBusiness {
    
	@Autowired
	private RoomData roomData;
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
	
	public Room save(Room room) throws SQLException{
	       return roomData.save(room);
	        
	}
	
}
