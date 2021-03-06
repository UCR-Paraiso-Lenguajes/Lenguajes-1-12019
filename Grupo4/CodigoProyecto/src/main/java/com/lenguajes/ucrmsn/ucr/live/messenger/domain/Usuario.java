package com.lenguajes.ucrmsn.ucr.live.messenger.domain;

import java.awt.Image;
import java.util.ArrayList;

public class Usuario {
	private int id;
	private String hash;
	private Image avatar;
	private String nombreUsuario;
	private ArrayList<Rol> listaRoles;
	private int cantidadMensajes;
	private ArrayList<Grupo> listaGrupos;

	public Usuario(int id, Image avatar, String nombreUsuario, int cantidadMensajes, String hash) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.nombreUsuario = nombreUsuario;
		this.cantidadMensajes = cantidadMensajes;
		listaRoles = new ArrayList<Rol>();
		listaGrupos = new ArrayList<Grupo>();
		this.hash = hash;
	}

	public void nuevoRol(Rol rol) {
		if (!listaRoles.contains(rol)) {
			listaRoles.add(rol);
		}
		throw new RuntimeException("El Usuario ya tiene el rol");
	}

	public void nuevoGrupo(Grupo grupo) {
		if (!listaGrupos.contains(grupo)) {
			listaGrupos.add(grupo);
		} else {
			throw new RuntimeException("El Usuario ya esta en el grupo");
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Image getAvatar() {
		return avatar;
	}

	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public ArrayList<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(ArrayList<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public int getCantidadMensajes() {
		return cantidadMensajes;
	}

	public void setCantidadMensajes(int cantidadMensajes) {
		this.cantidadMensajes = cantidadMensajes;
	}

	public ArrayList<Grupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(ArrayList<Grupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}
	
	
}
