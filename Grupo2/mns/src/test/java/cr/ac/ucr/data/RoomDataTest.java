package cr.ac.ucr.data;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cr.ac.ucr.exceptions.ProjectExceptions;


public class RoomDataTest {
	
	@Autowired
	private RoomData roomData;
	
	@Test
	public void crearInsertarGrupo() {
		
		
		
		try {
			roomData.save("Los marcianos", 2, 3, 3, 8);
		} catch (SQLException e) {
			throw new ProjectExceptions(e);
		}
		
		
		
		
	}

}
