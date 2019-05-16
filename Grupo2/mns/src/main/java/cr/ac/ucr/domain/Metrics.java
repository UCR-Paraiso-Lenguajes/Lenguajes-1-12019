package cr.ac.ucr.domain;

import java.util.Date;

import cr.ac.ucr.exceptions.ProjectExceptions;

public class Metrics {
	
	private int idMetric;
	private int roomsQuantity;
	private int usersQuantity;
	private Date lastMessage;
	private Date firstLogin;
	
	private User mostActiveUser; 
	private Room lastGroup;
	private Room mostActiveRoom;
	
	private static Metrics metrics;
	private Metrics() {}
	
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
		
		updateFirstLogin(msn)
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
		}
		else
		{
			boolean roomHasMoreMessagesThanTheStoredGroup = mostActiveRoom.obtenerCantMensajes() < msn.getRoomWhereThisMessageBelongs().obtenerCantMensajes() ;
			
			if( roomHasMoreMessagesThanTheStoredGroup )
			{
				mostActiveRoom = msn.getRoomWhereThisMessageBelongs();
			}
		}
		
		
		
		return this;
		
	}

	private Metrics updateLastDateMessage(Message msn) 
	{
		
		lastMessage = msn.getDate();
		
		return this;
	}


	private Metrics updateFirstLogin(Message msn) {
		if(firstLogin == null) firstLogin = msn.getDate();
		
		return this;
	}

	
}
