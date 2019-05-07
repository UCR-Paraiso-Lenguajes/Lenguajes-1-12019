package cr.ac.ucr.domain;

import java.util.Date;

public class Metrica {

	private int idMetrica;
	private int numberUsers;
	private int numberRooms;
	private Date lastDateMessage;
	private Date firstLoginDate;
	private int mostActiveUser;
	private int longerMessage;
	private int lastGroupCreated;
	private int mostActiveGroup;
	
	
	public Metrica() {
		super();
		
	}


	public Metrica(int idMetrica, int numberUsers, int numberRooms, Date lastDateMessage, Date firstLoginDate,
			int mostActiveUser, int longerMessage, int lastGroupCreated, int mostActiveGroup) {
		super();
		this.idMetrica = idMetrica;
		this.numberUsers = numberUsers;
		this.numberRooms = numberRooms;
		this.lastDateMessage = lastDateMessage;
		this.firstLoginDate = firstLoginDate;
		this.mostActiveUser = mostActiveUser;
		this.longerMessage = longerMessage;
		this.lastGroupCreated = lastGroupCreated;
		this.mostActiveGroup = mostActiveGroup;
	}


	public int getIdMetrica() {
		return idMetrica;
	}


	public void setIdMetrica(int idMetrica) {
		this.idMetrica = idMetrica;
	}


	public int getNumberUsers() {
		return numberUsers;
	}


	public void setNumberUsers(int numberUsers) {
		this.numberUsers = numberUsers;
	}


	public int getNumberRooms() {
		return numberRooms;
	}


	public void setNumberRooms(int numberRooms) {
		this.numberRooms = numberRooms;
	}


	public Date getLastDateMessage() {
		return lastDateMessage;
	}


	public void setLastDateMessage(Date lastDateMessage) {
		this.lastDateMessage = lastDateMessage;
	}


	public Date getFirstLoginDate() {
		return firstLoginDate;
	}


	public void setFirstLoginDate(Date firstLoginDate) {
		this.firstLoginDate = firstLoginDate;
	}


	public int getMostActiveUser() {
		return mostActiveUser;
	}


	public void setMostActiveUser(int mostActiveUser) {
		this.mostActiveUser = mostActiveUser;
	}


	public int getLongerMessage() {
		return longerMessage;
	}


	public void setLongerMessage(int longerMessage) {
		this.longerMessage = longerMessage;
	}


	public int getLastGroupCreated() {
		return lastGroupCreated;
	}


	public void setLastGroupCreated(int lastGroupCreated) {
		this.lastGroupCreated = lastGroupCreated;
	}


	public int getMostActiveGroup() {
		return mostActiveGroup;
	}


	public void setMostActiveGroup(int mostActiveGroup) {
		this.mostActiveGroup = mostActiveGroup;
	}
	
	
	
}
