package com.chat.domain;

import java.util.Iterator;

public class ChatRoom {

	private int id;
	private String name;
	private int version;
	private String url;
	private Iterator<User> UserList;
	
	public ChatRoom() {
		super();
	}

	public ChatRoom(int id, String name, int version, String url, Iterator<User> userList) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.url = url;
		UserList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Iterator<User> getUserList() {
		return UserList;
	}

	public void setUserList(Iterator<User> userList) {
		UserList = userList;
	}
	
	
	
	
}
