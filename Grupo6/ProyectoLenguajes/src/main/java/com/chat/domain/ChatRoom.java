package com.chat.domain;

import java.util.Iterator;

public class ChatRoom {

	private int id;
	private String name;
	private int version;
	private String url;
	private Iterator<User> userList;

	public ChatRoom(int id, String name, int version, String url, Iterator<User> userList) {
		super();
		if (id < 0)
			throw new RuntimeException("El id de la sala debe ser mayor  0.");
		if (name == null || name.trim().equals(""))
			throw new RuntimeException("El nombre es requerido");
		if (version < 0)
			throw new RuntimeException("La version de la sala debe ser mayor  0.");
		if (url == null || url.trim().equals(""))
			throw new RuntimeException("La url es requerida");
		if (userList.hasNext() == false)
			throw new RuntimeException("La sala debe contener un usuario");
		this.id = id;
		this.name = name;
		this.version = version;
		this.url = url;
		this.userList = userList;
	}

	public ChatRoom() {
		super();
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
		return userList;
	}

	public void setUserList(Iterator<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "ChatRoom [id=" + id + ", name=" + name + ", version=" + version + ", url=" + url + ", userList="
				+ userList + "]";
	}

}
