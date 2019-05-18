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
	public void ProcessMessages() 
	{
		User user = new User();
		Room room = new Room (user);
		Message mns1 = new Message("mensaje 1");
		Message mns2 = new Message("mensaje 2");
		
		room.process(mns1);
		
		assertEquals( 1, room.getTotalMessages() );
		
		room.process(mns2);
		
		assertEquals( 2, room.getTotalMessages() );
		assertEquals( "mensaje 1", room.getFirst().getContent() );
		
		for(int i =0; i<60 ;i++)
		{
			room.process(new Message("mensaje "+i));
		}
		
		assertEquals( 50, room.getTotalMessages() );
	}
	
	
	@Test
	public void OrderOfMessages() 
	{
		User user = new User();
		Room room = new Room (user);
			
		for(int i =0; i<60 ;i++)
		{
			room.process(new Message("mensaje "+i));
			
			if( i >50)
			{
				assertEquals( "mensaje "+(i-49), room.getFirst().getContent() );
			}
		}
		
		assertEquals( 50, room.getTotalMessages() );
	}

	
	//hacer test de JOIN
}


