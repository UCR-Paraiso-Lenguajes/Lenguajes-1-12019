package cr.ac.ucr.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import cr.ac.ucr.exceptions.ProjectExceptions;

public final class Room extends RoomConvention{
	
	private int idRoom;
	private String name;
	private int version;
	private User roomAdministrator;
	private User roomOwner;
	private HashSet<User> users = new HashSet<>();
	private final int MAX_QUEUE=50; 
	private final int MAX_USERS=50; 
	private	BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(MAX_QUEUE);
	
	
	
	public Room() {
		
		super();
		this.version = 0;
		
	}

	public Room(User roomOwner) {
		this.setRoomOwner(this.setRoomAdministrator(roomOwner)); 
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
	
	public boolean isFull() {
		return users.size() == MAX_USERS;
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

	public int getVersion() {
		return version;
	}

	public void updateVersion() {
		this.version++;
	}

	public User getRoomAdministrator() {
		return roomAdministrator;
	}

	public User setRoomAdministrator(User roomAdministrator) {
		this.roomAdministrator = roomAdministrator;
		return roomAdministrator;
	}

	public User getRoomOwner() {
		return roomOwner;
	}

	public void setRoomOwner(User roomOwner) {
		this.roomOwner = roomOwner;
	}

	public Iterator<Message> getMessages() {
		return messages.iterator();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", name=" + name + ", version=" + version + ", roomAdministrator="
				+ roomAdministrator + ", roomOwner=" + roomOwner + ", users=" + users + ", MAX_QUEUE=" + MAX_QUEUE
				+ ", MAX_USERS=" + MAX_USERS + ", messages=" + messages + "]";
	}

	
	
}
