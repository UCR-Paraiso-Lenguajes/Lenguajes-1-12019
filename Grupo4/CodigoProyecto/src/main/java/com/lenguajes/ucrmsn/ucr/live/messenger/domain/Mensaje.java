package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

public class Mensaje {
	private int id;
	private Usuario usuario;
	private String contenido;
	private int version;

	public Mensaje(int id, Usuario usuario, String contenido, int version) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contenido = contenido;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
