package cr.ac.ucr.domain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class Room extends RoomConvention{
	
	
	private final int MAX_QUEUE=50; 
	private	BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(MAX_QUEUE);
	
	int obtenerCantMensajes()
	{
		return messages.size();
	}

	@Override
	protected void updateMetrics(Message message)
	{
		Metrics.updateMetrics();
	}

	@Override
	protected void serialize(Message message)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void insertMessage(Message message) 
	{
		if(obtenerCantMensajes() >= MAX_QUEUE) 
		{
			messages.poll();
		}
		
		messages.add(message);
		
	}

	Message getFirst()
	{
		return  messages.peek();
	}

}
