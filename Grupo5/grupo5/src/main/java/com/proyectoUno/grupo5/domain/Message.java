package com.proyectoUno.grupo5.domain;

import java.util.Date;
import java.util.Map;

public class Message {
	
	
	private int idMessage;
	private Date fecha;
	private String contenido;
	private int userSendThatMessage;
	private int idRoom;
	
	public Message(int idMessage, Date fecha, String contenido, int userSendThatMessage, int idRoom) {
		super();
		this.idMessage = idMessage;
		this.fecha = fecha;
		this.contenido = contenido;
		this.userSendThatMessage = userSendThatMessage;
		this.idRoom = idRoom;
	}

	
	public Message(String contenido, int userSendThatMessage, int idRoom) {
		super();
		this.contenido = contenido;
		this.userSendThatMessage = userSendThatMessage;
		this.idRoom = idRoom;
	}



	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public Message() {
		
	}

	public int getIdMessage() {
		return idMessage;
	}


	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public int getUserSendThatMessage() {
		return userSendThatMessage;
	}


	public void setUserSendThatMessage(int userSendThatMessage) {
		this.userSendThatMessage = userSendThatMessage;
	}


	@Override
	public String toString() {
		return "Message{" +
				"idMessage=" + idMessage +
				", fecha=" + fecha +
				", contenido='" + contenido + '\'' +
				", userSendThatMessage=" + userSendThatMessage +
				", idRoom=" + idRoom +
				'}';
	}
}
