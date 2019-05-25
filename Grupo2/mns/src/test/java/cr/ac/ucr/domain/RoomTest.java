package cr.ac.ucr.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTest {


	@Test
	public void PrecosarMensajes() 
	{
		Room room = new Room ();
		Message mns1 = new Message("mensaje 1");
		Message mns2 = new Message("mensaje 2");
		
		room.process(mns1);
		
		assertEquals( 1, room.obtenerCantMensajes() );
		
		room.process(mns2);
		
		assertEquals( 2, room.obtenerCantMensajes() );
		assertEquals( "mensaje 1", room.getFirst().getContent() );
		
		for(int i =0; i<60 ;i++)
		{
			room.process(new Message("mensaje "+i));
		}
		
		assertEquals( 50, room.obtenerCantMensajes() );
	}
	
	
	@Test
	public void OrderOfMensajes() 
	{
		Room room = new Room ();
			
		for(int i =0; i<60 ;i++)
		{
			room.process(new Message("mensaje "+i));
			
			if( i >50)
			{
				assertEquals( "mensaje "+(i-49), room.getFirst().getContent() );
			}
		}
		
		assertEquals( 50, room.obtenerCantMensajes() );
	}

}


