package cr.ac.ucr.domain;

import java.util.Date;

import cr.ac.ucr.exceptions.ProjectExceptions;

public class Metrics {
	
	private int idMetric;//identificador
	private int roomsQuantity;//Cantidad de rooms globales
	private int usersQuantity;//Cantidad de usuarios globales
	private Date lastMessage;//Fecha del último mensaje.
	private Date firstLogin;//Fecha del 1er login.
	private Message longestMessage;//Mensaje más largo.
	private User mostActiveUser; //Usuario con más mensajes
	private int mostActiveUserMessageAmount;// y su cantidad.
	private Room lastRoomCreated;//Último grupo creado.
	private Room mostActiveRoom;//Grupo con más mensajes
	private int mostActiveRoomMessageAmount;// y su cantidad.
	private double usersPromedyByRoom;//Promedio de usuarios por grupo.
	
	
	private static Metrics metrics;
	private Metrics() {}
	
	public void setState(int roomsQuantity, int usersQuantity) 
	{
		
	}
	
	public static Metrics getInstance() 
	{
		if(metrics == null) metrics = new Metrics();
		
		return metrics;
	}
	
	public void updateMetrics(Message msn) 
	{
		if(msn == null) throw new ProjectExceptions("El mensaje no puede ser vacío");
		
		updateLastDateMessage(msn).
		
		and().
		
		updateRoomWithMoreMessages(msn).
		
		and().
		
		updateFirstLogin(msn).
		
		and().
		
		updateLongestMessage(msn).
		
		and().
		
		updateMostActiveUser(msn)
		;
	}
	

	private Metrics and() 
	{
		return this;
	}

	
	private Metrics updateRoomWithMoreMessages(Message msn) 
	{
		if(mostActiveRoom == null)
		{
			mostActiveRoom = msn.getRoomWhereThisMessageBelongs();
			mostActiveRoomMessageAmount = msn.getRoomWhereThisMessageBelongs().getTotalMessages();
		}
		else
		{
			boolean roomHasMoreMessagesThanTheStoredGroup = mostActiveRoom.getTotalMessages() < msn.getRoomWhereThisMessageBelongs().getTotalMessages() ;
			
			if( roomHasMoreMessagesThanTheStoredGroup )
			{
				mostActiveRoom = msn.getRoomWhereThisMessageBelongs();
				mostActiveRoomMessageAmount = msn.getRoomWhereThisMessageBelongs().getTotalMessages();
			}
		}
		
		
		
		return this;
		
	}

	private Metrics updateLastDateMessage(Message msn) 
	{
		
		this.lastMessage = msn.getDate();
		
		return this;
	}
	
	
	public Metrics updateRooms(Room room) 
	{
		
		lastRoomCreated = room;	
		
		roomsQuantity=roomsQuantity+1;
		
		return this;
	}
	
	
	public Metrics updateUsersQuantity() 
	{
		
		usersQuantity = usersQuantity+1;
		
		return this;
	}

	private Metrics updateFirstLogin(Message msn) {
		if(firstLogin == null) firstLogin = msn.getDate();
		
		return this;
	}

	
	private Metrics updateLongestMessage(Message msn) 
	{
		if(longestMessage == null)
		{
			longestMessage = msn;
		}
		else if( msn.isLongerThan(longestMessage) )
		{
				longestMessage = msn;	
		}
		
		return this;
		
	}
	
	private Metrics updateMostActiveUser(Message msn) {
		
		msn.getSender().updateTotalSendedMessages();
		
		if(mostActiveUser == null)
		{
			mostActiveUser = msn.getSender();
			mostActiveUserMessageAmount = msn.getSender().getTotalSendedMessages();
		}
		else if(msn.getSender().hasMoreMessagesThan(mostActiveUser)) {
			mostActiveUser =  msn.getSender();
			mostActiveUserMessageAmount = msn.getSender().getTotalSendedMessages();
		}
		
		return this;
	}
	
	
	public void updateUsersPromedyByRoom() {
		usersPromedyByRoom = usersQuantity / roomsQuantity;
	}
	
}
