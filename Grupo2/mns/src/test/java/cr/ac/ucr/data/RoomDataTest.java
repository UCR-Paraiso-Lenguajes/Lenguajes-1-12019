package cr.ac.ucr.data;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cr.ac.ucr.domain.Room;
import cr.ac.ucr.domain.User;
import cr.ac.ucr.exceptions.ProjectExceptions;


public class RoomDataTest {
	
	@Autowired
	private RoomData roomData;
	
	@Test
	public void crearInsertarGrupo() {
		
		
		User u = new User();
		u.setIdUser(1);
		Room r = new Room();
		r.setIdRoom(1);
		r.setName("Grupo2");
		r.setRoomAdministrator(u);
		r.setRoomOwner(u);
		r.updateVersion();
		
		try {
			
			Room r1= roomData.save(r);
			assertEquals(r1.getName(), "Grupo2");
		} catch (SQLException e) {
			throw new ProjectExceptions(e);
		}
		
		
		
		
	}

	
	private Room getRoom() {

		return r;
		
	}
}
