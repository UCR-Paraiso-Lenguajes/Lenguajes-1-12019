package cr.ac.ucr.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cr.ac.ucr.business.RoomBusiness;
import cr.ac.ucr.domain.Room;


public class RoomDataTest {
	
	@Autowired
	private RoomData roomData;
	private RoomBusiness roomBusiness;
	
	@Test
	public void crearInsertarGrupo() {
		
		
		
		roomBusiness.save("Los marcianos", 2, 3, 3, 8);
	}

}
