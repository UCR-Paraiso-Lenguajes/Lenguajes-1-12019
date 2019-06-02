package com.chat.domain;

public class HistorialLogueo {

	private int id;
	private int id_user;
	private String fecha;
	
	
	
	public HistorialLogueo(int id, String fecha, int id_user) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.fecha = fecha;
	}
	public HistorialLogueo( int id_user, String fecha) {
		super();
		this.id_user = id_user;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "HistorialLogueo [id=" + id + ", id_user=" + id_user + ", fecha=" + fecha + "]";
	}
	
}
