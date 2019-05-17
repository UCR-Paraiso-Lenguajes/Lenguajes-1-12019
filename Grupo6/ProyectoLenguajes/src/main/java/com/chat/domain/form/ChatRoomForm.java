package com.chat.domain.form;


import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.chat.domain.User;

public class ChatRoomForm {
	
	private int codChat;
	@NotNull
	@Size(min=2, max=500)
	private String name;
	@NotNull
	@Min(2)
	private int version;
	private String url;
	@NotNull
	private Iterator<User> userList;
	
	private List listaChat;
	
	public ChatRoomForm() {
	
	}
	
	public int getCodChat() {
		return codChat;
	}
	public void setCodChat(int codChat) {
		this.codChat = codChat;
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

	public List getListaChat() {
		return listaChat;
	}

	public void setListaChat(List listaChat) {
		this.listaChat = listaChat;
	}

	public Iterator<User> getUserList() {
		return userList;
	}
	public void setUserList(Iterator<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "ChatRoomForm [codChat=" + codChat + ", name=" + name + ", version=" + version + ", url=" + url
				+ ", userList=" + userList + ", listaChat=" + listaChat + "]";
	}
	

	
}
