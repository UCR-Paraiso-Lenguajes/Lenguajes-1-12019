package com.proyectoUno.grupo5.domain;

import java.util.Date;
import java.util.Map;

public class Message {
	
	
	private int idMessage;
	private Date fecha;
	private String contenido;
	private User userSendThatMessage;
	
	public Message(int idMessage, Date fecha, String contenido, User userSendThatMessage) {
		super();
		this.idMessage = idMessage;
		this.fecha = fecha;
		this.contenido = contenido;
		this.userSendThatMessage = userSendThatMessage;
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


	public User getUserSendThatMessage() {
		return userSendThatMessage;
	}


	public void setUserSendThatMessage(User userSendThatMessage) {
		this.userSendThatMessage = userSendThatMessage;
	}
	
	
	

}
