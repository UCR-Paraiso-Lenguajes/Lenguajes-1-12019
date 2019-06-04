package cr.ac.ucr.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class RoomDataTest {
	
	@Autowired
	private RoomData roomData;
	
	@Test
	public void crearInsertarGrupo() {
		
		assertEquals("Administrador",roles.get(1).getDetail() );
	}

}
