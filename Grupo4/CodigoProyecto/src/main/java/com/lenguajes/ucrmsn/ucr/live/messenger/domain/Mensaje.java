package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import com.lenguajes.ucrmsn.ucr.live.messenger.excepciones.MensajeException;

public class Mensaje {
	private int id;
	private static int cont=0;

	private Usuario usuario;
	private String contenido;
	private int version;
	private Grupo grupo;
	

	public Mensaje( Usuario usuario, String contenido, int version,Grupo grupo) throws MensajeException {
		super();
		if (usuario==null && contenido.equals(null)) {
			throw new MensajeException("mensaje vacio");
		}
		cont=cont+1;
		this.id = cont;
		this.usuario = usuario;
		this.contenido = contenido;
		this.version = version;
		this.grupo=grupo;
		
	}
	public Mensaje() {
		super();
		// TODO Auto-generated constructor stub
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
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
