package cr.ac.ucr.domain;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class Room extends RoomConvention{
	
	private User roomAdministrator;
	private User roomOwner;
	private ArrayList<User> roomUsers = new ArrayList<>();
	private final int MAX_QUEUE=50; 
	private	BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(MAX_QUEUE);
	
	int obtenerCantMensajes()
	{
		return messages.size();
	}

	@Override
	protected void updateMetrics(Message message)
	{
		Metrics.getInstance().updateMetrics(message);
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
	
	
	int totalUsers() {
		return roomUsers.size();
	}
}
