package cr.ac.ucr.domain;

import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import cr.ac.ucr.exceptions.ProjectExceptions;

public final class Room extends RoomConvention{
	
	private int idRoom;
	private User roomAdministrator;
	private User roomOwner;
	private HashSet<User> users = new HashSet<>();
	private final int MAX_QUEUE=50; 
	private	BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(MAX_QUEUE);
	
	
	public Room(User roomOwner) {
		this.roomOwner = this.roomAdministrator = roomOwner; 
		join(roomOwner); 
		Metrics.getInstance().updateRooms(this);
	}

	int getTotalMessages()
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
		if(getTotalMessages() >= MAX_QUEUE) 
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
		return users.size();
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}

	@Override
	protected void join(User user) {
		if(user == null) throw new ProjectExceptions("Tiene que haber un usuario");
		users.add(user);
		Metrics.getInstance().updateUsersPromedyByRoom();
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	
}
