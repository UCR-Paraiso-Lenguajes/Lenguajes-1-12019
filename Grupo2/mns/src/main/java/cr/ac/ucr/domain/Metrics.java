package cr.ac.ucr.domain;

import java.util.Date;

public class Metrics {
	
	private int idMetric;
	private int roomsQuantity;
	private int usersQuantity;
	private Date lastMessage;
	private Date firstLogin;
	
	//crear User y Group
	
	//private User mostActiveUser; 
	private Room lastGroup;
	private Room mostActiveGroup;
	
	private static Metrics metrics;
	private Metrics() {}
	
	public static Metrics getInstance() 
	{
		if(metrics == null) metrics = new Metrics();
		
		return metrics;
	}
	
	public void updateMetrics(Message msn) 
	{
		//TODO validaciones if ()
		
		updateLastDateMessage(msn).
		
		and().
		
		updateGruopWithMoreMessages(msn);
	}
	
	private Metrics and() 
	{
		return this;
	}

	
	private Metrics updateGruopWithMoreMessages(Message msn) 
	{
		if(mostActiveGroup == null)
		{
			mostActiveGroup = msn.getRoomWhereThisMessageBelongs();
		}
		else
		{
			boolean theGroupHasMoreMessagesThanTheStoredGroup = mostActiveGroup.obtenerCantMensajes() < msn.getRoomWhereThisMessageBelongs().obtenerCantMensajes() ;
			
			if( theGroupHasMoreMessagesThanTheStoredGroup )
			{
				mostActiveGroup = msn.getRoomWhereThisMessageBelongs();
			}
		}
		
		
		
		return this;
		
	}

	private Metrics updateLastDateMessage(Message msn) 
	{
		lastMessage = msn.getDate();
		
		return this;
	}
}
