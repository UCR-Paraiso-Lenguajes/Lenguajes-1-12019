package cr.ac.ucr.domain;

import java.awt.Image;
import java.util.ArrayList;

public class User {

	private int idUser;
	private String name;
	private String hash;
	private String email;
	private Image avatar;
	private ArrayList<Role> roleList = new ArrayList<Role>();
	private ArrayList<Room> listRoom = new ArrayList<Room>();
	private int totalSendedMessages;
	
	public User() {
		
		Metrics.getInstance().updateUsersQuantity();
		
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser= idUser;
	}
	
	public int getTotalSendedMessages() {
		return totalSendedMessages;
	}

	public void updateTotalSendedMessages() {
		this.totalSendedMessages = totalSendedMessages + 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//validacion if
		this.name = name;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		//validacion if
		this.hash = hash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		//validacion if
		this.email = email;
	}

	public Image getAvatar() {
		return avatar;
	}

	public void setAvatar(Image avatar) {
		//validacion if
		this.avatar = avatar;
	}
	
	public boolean hasMoreMessagesThan(User user) {
		return this.totalSendedMessages > user.totalSendedMessages;
	}
	
}
