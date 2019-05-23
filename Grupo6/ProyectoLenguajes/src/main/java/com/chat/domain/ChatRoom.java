package com.chat.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ChatRoom {

	private int id;
	private String name;
	private int version;
	private String url;
	private List<User> listUsers;
	private List<Message> listMessage;

	public ChatRoom(int id, String name, int version, String url, List<User> listUsers, List<Message> listMessage) {
		super();
		if (id < 0)
			throw new RuntimeException("El id de la sala debe ser mayor  0.");
		if (name == null || name.trim().equals(""))
			throw new RuntimeException("El nombre es requerido");
		if (version < 0)
			throw new RuntimeException("La version de la sala debe ser mayor  0.");
		if (url == null || url.trim().equals(""))
			throw new RuntimeException("La url es requerida");
		this.id = id;
		this.name = name;
		this.version = version;
		this.url = url;
		this.listUsers = Collections.synchronizedList(new ArrayList<User>());
		this.listMessage = Collections.synchronizedList(new ArrayList<Message>());
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

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public List<Message> getListMessage() {
		return listMessage;
	}

	public void setListMessage(List<Message> listMessage) {
		this.listMessage = listMessage;
	}

	@Override
	public String toString() {
		return "ChatRoom [id=" + id + ", name=" + name + ", version=" + version + ", url=" + url + ", listUsers="
				+ listUsers + ", listMessage=" + listMessage + "]";
	}

}
