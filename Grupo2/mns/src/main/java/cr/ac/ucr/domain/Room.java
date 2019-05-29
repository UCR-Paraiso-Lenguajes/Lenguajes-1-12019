package cr.ac.ucr.domain;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class Room extends RoomConvention{
	
	private int idRoom;
	private String nombre;
	private ArrayList<User> usersList;
	private User owner;
	private User admin;
	private final int MAX_QUEUE=50; 
	private	BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(MAX_QUEUE);
	
	
	int obtenerCantMensajes()
	{
		return messages.size();
	}

	@Override
	protected void updateMetrics(Message message)
	{
		
		
	}

	@Override
	protected void serialize(Message message)
	{

		
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

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<User> usersList) {
		this.usersList = usersList;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public BlockingQueue<Message> getMessages() {
		return messages;
	}

	public void setMessages(BlockingQueue<Message> messages) {
		this.messages = messages;
	}

	public int getMAX_QUEUE() {
		return MAX_QUEUE;
	}
	
	

}
